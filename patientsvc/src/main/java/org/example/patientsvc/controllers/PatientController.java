package org.example.patientsvc.controllers;

import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.services.PatientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
