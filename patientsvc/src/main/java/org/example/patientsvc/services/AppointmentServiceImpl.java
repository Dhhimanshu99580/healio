package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;
import org.example.patientsvc.entities.Appointment;
import org.example.patientsvc.entities.DoctorAvailability;
import org.example.patientsvc.entities.Doctors;
import org.example.patientsvc.entities.PatientEntity;
import org.example.patientsvc.exceptions.AppointmentConflictException;
import org.example.patientsvc.exceptions.DoctorNotAvailableException;
import org.example.patientsvc.exceptions.DoctorNotFoundException;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.example.patientsvc.mappers.AppointmentMapper;
import org.example.patientsvc.repositories.AppointmentRepository;
import org.example.patientsvc.repositories.DoctorAvailabilityRepository;
import org.example.patientsvc.repositories.DoctorsRepository;
import org.example.patientsvc.repositories.PatientRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
    public UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request) {

    }
}
