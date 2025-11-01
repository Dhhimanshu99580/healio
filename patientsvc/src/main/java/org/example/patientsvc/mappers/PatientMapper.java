package org.example.patientsvc.mappers;

import org.example.patientsvc.domains.PatientCreationRequest;
import org.example.patientsvc.domains.PatientCreationResponse;
import org.example.patientsvc.domains.PatientDeletionResponse;
import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.entities.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

  @Mapping(source = "name", target = "patientName")
  @Mapping(source = "phone", target = "patientPhoneNumber")
  PatientResponseDTO mapPatientResponseDTO(PatientEntity patient);

  PatientEntity mapPatientRequestToEntity(PatientCreationRequest request);

  @Mapping(source="id", target="patientId")
  @Mapping(source="name", target="patientName")
  @Mapping(source="email",target="patientEmail")
  @Mapping(source="address", target="patientAddress")
  @Mapping(source="phone", target="patientPhone")
  PatientCreationResponse mapPatientEntityToResponse(PatientEntity patientEntity);

  PatientDeletionResponse mapPatientEntityToDeletionResponse(PatientEntity patientEntity);
}
