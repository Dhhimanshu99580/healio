package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.AppointmentDeletionRequest;
import org.example.patientsvc.domains.AppointmentDeletionResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;
import org.example.patientsvc.entities.Appointment;
import org.example.patientsvc.entities.DoctorAvailability;
import org.example.patientsvc.entities.Doctors;
import org.example.patientsvc.entities.PatientEntity;
import org.example.patientsvc.exceptions.AppointmentConflictException;
import org.example.patientsvc.exceptions.AppointmentNotFoundException;
import org.example.patientsvc.exceptions.DoctorNotAvailableException;
import org.example.patientsvc.exceptions.DoctorNotFoundException;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.example.patientsvc.mappers.AppointmentMapper;
import org.example.patientsvc.repositories.AppointmentRepository;
import org.example.patientsvc.repositories.DoctorAvailabilityRepository;
import org.example.patientsvc.repositories.DoctorsRepository;
import org.example.patientsvc.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private DoctorsRepository doctorsRepository;
    private PatientRepository patientRepository;
    private DoctorAvailabilityRepository doctorAvailabilityRepository;
    private AppointmentMapper appointmentMapper;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  DoctorsRepository doctorsRepository,
                           PatientRepository patientRepository,
                                  DoctorAvailabilityRepository doctorAvailabilityRepository,
    AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.doctorsRepository = doctorsRepository;
        this.patientRepository = patientRepository;
        this.doctorAvailabilityRepository = doctorAvailabilityRepository;
        this.appointmentMapper=appointmentMapper;
    }
    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        Doctors doctor = doctorsRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException("Requested doctor was not found"));
        PatientEntity patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        DoctorAvailability availability = doctorAvailabilityRepository
                .findByDoctorIdAndDate(doctor.getId(), request.getDateOfAppointment().toLocalDate())
                .orElseThrow(() -> new DoctorNotAvailableException("Doctor not available on requested date"));
        LocalTime appointmentTime = request.getDateOfAppointment().toLocalTime();
        if (appointmentTime.isBefore(availability.getStartTime()) ||
                appointmentTime.isAfter(availability.getEndTime())) {
            throw new DoctorNotAvailableException("Doctor not available at requested time");
        }
        boolean hasConflict = appointmentRepository.existsByDoctorAndDateOfAppointment(doctor, request.getDateOfAppointment());
        if (hasConflict) {
            throw new AppointmentConflictException("Slot already booked");
        }
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setDateOfAppointment(request.getDateOfAppointment());
        appointment.setAddedOn(LocalDateTime.now());
        appointment.setUpdatedOn(LocalDateTime.now());
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.mapAppointmentResponse(appointment);
    }
    @Override
    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(appointmentMapper::mapAppointmentResponse)
                .toList();
    }

    @Override
    public AppointmentResponse getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + id));
        return appointmentMapper.mapAppointmentResponse(appointment);
    }

    @Override
    public UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + request.getAppointmentId()));

        // If status is CANCEL, we can mark it as cancelled or delete it
        // For now, let's update the updatedOn timestamp
        appointment.setUpdatedOn(LocalDateTime.now());
        appointment = appointmentRepository.save(appointment);

        UpdateAppointmentResponse response = new UpdateAppointmentResponse();
        response.setPatientId(appointment.getPatient().getId());
        response.setAppointmentId(appointment.getId());
        response.setMessage("Appointment updated successfully");
        return response;
    }

    @Override
    public AppointmentDeletionResponse deleteAppointment(AppointmentDeletionRequest request) {
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with id: " + request.getAppointmentId()));

        AppointmentDeletionResponse response = new AppointmentDeletionResponse();
        response.setAppointmentId(appointment.getId());
        response.setDateOfAppointment(appointment.getDateOfAppointment());
        response.setDoctorName(appointment.getDoctor().getName());
        response.setPatientName(appointment.getPatient().getName());

        appointmentRepository.delete(appointment);
        return response;
    }
}
