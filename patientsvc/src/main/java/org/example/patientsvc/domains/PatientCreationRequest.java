package org.example.patientsvc.domains;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientCreationRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;
    @NotNull
    private String dateOfBirth;
}
