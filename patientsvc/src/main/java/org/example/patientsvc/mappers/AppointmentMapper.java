package org.example.patientsvc.mappers;

import org.example.patientsvc.domains.AppointmentResponse;
import org.example.patientsvc.entities.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(source = "id", target="appointmentId")
    @Mapping(source="doctor.name",target="nameOfDoctor")
    AppointmentResponse mapAppointmentResponse(Appointment appointment);
}
