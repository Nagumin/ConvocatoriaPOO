package com.example.crudrapido.service;

import com.example.crudrapido.entity.Docente;
import com.example.crudrapido.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getDocentes() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> getDocente(Long id) {
        return docenteRepository.findById(id);
    }

    public void saveOrUpdate(Docente docente) {
        // Verificar si ya existe un docente con el mismo número y tipo de documento
        Optional<Docente> existingDocente = docenteRepository.findByDocumentNumberAndDocumentType(
                docente.getDocumentNumber(), docente.getDocumentType());

        if (existingDocente.isPresent() && !existingDocente.get().getDocenteId().equals(docente.getDocenteId())) {
            // Si existe y no es el mismo docente, lanzar una excepción o manejar el error
            throw new IllegalStateException("Ya existe un docente con el mismo número y tipo de documento.");
        }

        docenteRepository.save(docente);
    }

    public void delete(Long id) {
        docenteRepository.deleteById(id);
    }
}
