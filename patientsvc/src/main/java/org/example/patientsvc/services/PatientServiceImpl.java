package org.example.patientsvc.services;

import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.entities.PatientEntity;
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
}
