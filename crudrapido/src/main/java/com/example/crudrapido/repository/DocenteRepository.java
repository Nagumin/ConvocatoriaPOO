package com.example.crudrapido.repository;

import com.example.crudrapido.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Optional<Docente> findByDocumentNumberAndDocumentType(String documentNumber, String documentType);
}
