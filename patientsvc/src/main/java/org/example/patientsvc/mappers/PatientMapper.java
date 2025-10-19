package org.example.patientsvc.mappers;

import org.example.patientsvc.domains.PatientResponseDTO;
import org.example.patientsvc.entities.PatientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

  @Mapping(source = "name", target = "patientName")
  @Mapping(source = "phone", target = "patientPhoneNumber")
  PatientResponseDTO mapPatientResponseDTO(PatientEntity patient);
}
