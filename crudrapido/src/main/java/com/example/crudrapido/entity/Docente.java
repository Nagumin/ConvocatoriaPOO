package com.example.crudrapido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docenteId;

    private String firstName;
    private String lastName;

    @Column(name = "email_address", unique = true, nullable = false)
    private String email;

    @Column(name = "document_number", unique = true, nullable = false)
    private String documentNumber;

    @Column(name = "document_type", nullable = false)
    private String documentType;
}
