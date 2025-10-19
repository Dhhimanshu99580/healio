package org.example.patientsvc.services;

import org.example.patientsvc.domains.PatientResponseDTO;

import java.util.List;

public interface PatientService {
 List<PatientResponseDTO> getAllPatients();
}
