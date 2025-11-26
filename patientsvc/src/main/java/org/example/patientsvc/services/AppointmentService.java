package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.AppointmentDeletionRequest;
import org.example.patientsvc.domains.AppointmentDeletionResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;

import java.util.List;

public interface AppointmentService {
 AppointmentResponse bookAppointment(AppointmentRequest request);
 List<AppointmentResponse> getAllAppointments();
 AppointmentResponse getAppointmentById(Long id);
 UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
 AppointmentDeletionResponse deleteAppointment(AppointmentDeletionRequest request);
}
