package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;

public interface AppointmentService {
 AppointmentResponse bookAppointment(AppointmentRequest request);
 UpdateAppointmentResponse updateAppointment(UpdateAppointmentRequest request);
}
