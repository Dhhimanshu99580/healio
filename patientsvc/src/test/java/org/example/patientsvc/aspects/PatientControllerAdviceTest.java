package org.example.patientsvc.aspects;

import org.example.patientsvc.exceptions.PatientNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zalando.problem.Problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PatientControllerAdviceTest {
    /**
     * Method under test: {@link PatientControllerAdvice#onPatientNotFoundException(PatientNotFoundException)}
     */
    @Test
    public void testOnPatientNotFoundException() {
        PatientControllerAdvice advice = new PatientControllerAdvice();
        Problem problem = advice.onPatientNotFoundException(new PatientNotFoundException("Patient not found"));
        Assertions.assertEquals("PATIENT_NOT_FOUND", problem.getTitle());
        Assertions.assertEquals("Patient not found", problem.getDetail());
        Assertions.assertNull(problem.getInstance());
        Assertions.assertNull(problem.getStatus());
    }
}
