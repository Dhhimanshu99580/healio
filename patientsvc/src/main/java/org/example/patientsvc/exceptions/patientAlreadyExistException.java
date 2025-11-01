package org.example.patientsvc.exceptions;

import javax.management.remote.JMXServerErrorException;

public class patientAlreadyExistException extends RuntimeException{
    public patientAlreadyExistException(String message) {
        super(message);
    }

    public patientAlreadyExistException(String message, String email, String phone) {
        super(message + " Email: " + email + ", Phone: " + phone);
    }
}
