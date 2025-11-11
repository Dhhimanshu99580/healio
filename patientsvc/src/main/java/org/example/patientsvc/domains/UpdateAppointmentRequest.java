package org.example.patientsvc.domains;

import lombok.Data;
import org.example.patientsvc.constants.ValidAppointments;

@Data
public class UpdateAppointmentRequest {
    private Long appointmentId;
    private ValidAppointments status;
}
