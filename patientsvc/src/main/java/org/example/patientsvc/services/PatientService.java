package org.example.patientsvc.services;

import org.example.patientsvc.domains.PatientCreationRequest;
import org.example.patientsvc.domains.PatientCreationResponse;
import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.domains.UpdatePatientDetails;

import java.util.List;

public interface PatientService {
 List<PatientResponseDTO> getAllPatients();

 PatientResponseDTO updatePatientDetails(UpdatePatientDetails updatePatientDetails);

 PatientCreationResponse createPatient(PatientCreationRequest request);
}
