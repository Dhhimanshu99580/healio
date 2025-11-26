package org.example.patientsvc.services;

import org.example.patientsvc.domains.PatientCreationRequest;
import org.example.patientsvc.domains.PatientCreationResponse;
import org.example.patientsvc.domains.PatientDeletionRequest;
import org.example.patientsvc.domains.PatientDeletionResponse;
import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.domains.UpdatePatientDetails;
import org.example.patientsvc.entities.PatientEntity;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.example.patientsvc.exceptions.patientAlreadyExistException;
import org.example.patientsvc.mappers.PatientMapper;
import org.example.patientsvc.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public PatientResponseDTO getPatientById(java.util.UUID id) {
        PatientEntity patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));
        return patientMapper.mapPatientResponseDTO(patient);
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

    @Override
    public PatientCreationResponse createPatient(PatientCreationRequest request) {
        if(patientRepository.existByEmailOrPhone(request.getEmail(), request.getPhone())) {
            throw new patientAlreadyExistException("Patient with given email {} or phone {} already exists",
                    request.getEmail(),request.getPhone());
        }
        PatientEntity patientEntity = patientMapper.mapPatientRequestToEntity(request);
        patientRepository.save(patientEntity);
        return patientMapper.mapPatientEntityToResponse(patientEntity);
    }
    @Override
    public PatientDeletionResponse deletePatient(PatientDeletionRequest request) {
        PatientEntity patientEntity = patientRepository.findById(request.getId()).orElseThrow(()-> new PatientNotFoundException("Patient not found with id: " + request.getId()));
        patientRepository.delete(patientEntity);
        return patientMapper.mapPatientEntityToDeletionResponse(patientEntity);
    }
}
