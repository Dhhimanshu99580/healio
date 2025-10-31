package org.example.patientsvc.controllers;

import jakarta.validation.Valid;
import org.example.patientsvc.domains.PatientCreationRequest;
import org.example.patientsvc.domains.PatientCreationResponse;
import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.domains.UpdatePatientDetails;
import org.example.patientsvc.services.PatientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientServiceImpl patientService;
    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path="/getDetails")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO>patients = patientService.getAllPatients();
        return ResponseEntity.ok().body(patients);
    }
    @PatchMapping(path="/updateDetails")
    public ResponseEntity<PatientResponseDTO> updatePatientDetails(@RequestBody @Valid UpdatePatientDetails updatePatientDetails) {
        return ResponseEntity.ok().body(patientService.updatePatientDetails(updatePatientDetails));
    }
    @PostMapping(path="/create-patient")
    public PatientCreationResponse createPatient(
            @Valid @RequestBody PatientCreationRequest request) {
        return patientService.createPatient(request);
    }
}
