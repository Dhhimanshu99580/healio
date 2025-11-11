package org.example.patientsvc.controllers;

import jakarta.validation.Valid;
import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;
import org.example.patientsvc.services.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping("/book")
    public AppointmentResponse bookAppointment(
            @RequestBody @Valid AppointmentRequest request
    ) {
        return appointmentService.bookAppointment(request);
    }
    @PutMapping("/update")
    public UpdateAppointmentResponse updateAppointment(
            @RequestBody @Valid UpdateAppointmentRequest request
    ) {
        return appointmentService.updateAppointment(request);
    }
}
