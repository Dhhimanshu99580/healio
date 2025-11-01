package org.example.patientsvc.aspects;


import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

@RestController
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PatientControllerAdvice {

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Problem onPatientNotFoundException(PatientNotFoundException e) {
        log.error("PatientNotFoundException :: {}", e.getMessage());
        return Problem.builder()
                .withTitle("PATIENT_NOT_FOUND")
                .withDetail(e.getMessage())
                .build();
    }

}
