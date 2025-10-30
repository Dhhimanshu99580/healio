package org.example.patientsvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="prescription")
@Data
public class Prescription {
}
