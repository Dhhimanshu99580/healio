package org.example.patientsvc;


import lombok.extern.slf4j.Slf4j;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.Problem;


@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class PatientControllerAdvice {

    public static final String PATIENT_NOT_FOUND = "PATIENT WAS NOT FOUND";
    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Problem onPatientNotFoundException(Exception e) {
        log.error("Patient not found: {}", e.getMessage());
        return Problem.builder()
                .withTitle(PATIENT_NOT_FOUND)
                .withDetail(e.getMessage())
                .build();
    }
}
