package org.example.patientsvc.services;

import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.domains.UpdatePatientDetails;
import org.example.patientsvc.entities.PatientEntity;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.example.patientsvc.mappers.PatientMapper;
import org.example.patientsvc.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;
    public PatientServiceImpl(
            PatientRepository patientRepository,
            PatientMapper patientmapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientmapper;
    }
    @Override
    public List<PatientResponseDTO>getAllPatients() {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream().map(patientMapper::mapPatientResponseDTO).toList();
    }

    @Override
    public PatientResponseDTO updatePatientDetails(UpdatePatientDetails updatePatientDetails) {
        PatientEntity patientData = patientRepository.findById(updatePatientDetails.getId()).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patientData.setId(updatePatientDetails.getId());
        patientData.setName(updatePatientDetails.getName());
        patientData.setPhone(updatePatientDetails.getPhone());
        patientData.setEmail(updatePatientDetails.getEmail());
        patientData.setAddress(updatePatientDetails.getAddress());
        patientData.setDateOfBirth(updatePatientDetails.getDateOfBirth());
        patientRepository.save(patientData);
        return patientMapper.mapPatientResponseDTO(patientData);
    }
}
