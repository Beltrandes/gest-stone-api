package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.MaterialDTO;
import com.beltrandes.geststoneapi.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @GetMapping
    public ResponseEntity<List<MaterialDTO>> getAllMaterials() {
        return ResponseEntity.ok().body(materialService.getAll());
    }
}
