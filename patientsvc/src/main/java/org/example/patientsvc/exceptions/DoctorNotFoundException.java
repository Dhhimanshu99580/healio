package org.example.patientsvc.exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
