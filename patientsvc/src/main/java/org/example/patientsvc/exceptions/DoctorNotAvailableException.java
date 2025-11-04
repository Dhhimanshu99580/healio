package org.example.patientsvc.exceptions;

public class DoctorNotAvailableException extends RuntimeException{
    public DoctorNotAvailableException(String message) {
        super(message);
    }
}

