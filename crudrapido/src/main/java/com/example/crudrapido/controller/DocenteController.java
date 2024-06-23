package com.example.crudrapido.controller;

import com.example.crudrapido.entity.Docente;
import com.example.crudrapido.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/docentes")

public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> getAll() {
        return docenteService.getDocentes();
    }

    @GetMapping("/{docenteId}")
    public Optional<Docente> getBId(@PathVariable("docenteId") Long docenteId) {
        return docenteService.getDocente(docenteId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Docente docente) {
        docenteService.saveOrUpdate(docente);
    }

    @DeleteMapping("/{docenteId}")
    public void delete(@PathVariable("docenteId") Long docenteId) {
        docenteService.delete(docenteId);
    }
}

