package org.example.patientsvc.services;

import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;

public interface AppointmentService {
 AppointmentResponse bookAppointment(AppointmentRequest request);
}
