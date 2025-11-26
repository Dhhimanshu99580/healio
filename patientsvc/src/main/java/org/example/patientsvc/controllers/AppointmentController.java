package org.example.patientsvc.controllers;

import jakarta.validation.Valid;
import org.example.patientsvc.domains.AppointmentRequest;
import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.domains.AppointmentDeletionRequest;
import org.example.patientsvc.domains.AppointmentDeletionResponse;
import org.example.patientsvc.domains.UpdateAppointmentRequest;
import org.example.patientsvc.domains.UpdateAppointmentResponse;
import org.example.patientsvc.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book")
    public ResponseEntity<AppointmentResponse> bookAppointment(
            @RequestBody @Valid AppointmentRequest request
    ) {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<AppointmentResponse> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(
            @PathVariable Long id
    ) {
        AppointmentResponse appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateAppointmentResponse> updateAppointment(
            @RequestBody @Valid UpdateAppointmentRequest request
    ) {
        return ResponseEntity.ok(appointmentService.updateAppointment(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<AppointmentDeletionResponse> deleteAppointment(
            @RequestBody @Valid AppointmentDeletionRequest request
    ) {
        return ResponseEntity.ok(appointmentService.deleteAppointment(request));
    }
}
