package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.entities.Doctors;
import org.example.patientsvc.entities.PatientEntity;
import org.example.patientsvc.exceptions.DoctorNotFoundException;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.example.patientsvc.repositories.AppointmentRepository;
import org.example.patientsvc.repositories.DoctorsRepository;
import org.example.patientsvc.repositories.PatientRepository;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private DoctorsRepository doctorsRepository;
    private PatientRepository patientRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  DoctorsRepository doctorsRepository,
                           PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorsRepository = doctorsRepository;
        this.patientRepository = patientRepository;
    }
    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request) {
        validateRequest(request);
    }
    protected void validateRequest(AppointmentRequest request) {
        Doctors doctors = doctorsRepository.findById(request.getDoctorId()).orElseThrow(()->new DoctorNotFoundException("Requested doctor was not found"));
        PatientEntity patient = patientRepository.findById(request.getPatientId()).orElseThrow(()->new PatientNotFoundException("Patient not available"));

    }
}
