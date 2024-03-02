package com.beltrandes.geststoneapi.controllers;

import com.beltrandes.geststoneapi.dtos.MaterialDTO;
import com.beltrandes.geststoneapi.dtos.UpdateMaterialPriceDTO;
import com.beltrandes.geststoneapi.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<MaterialDTO> createMaterial(@RequestBody MaterialDTO materialDTO) {
        return ResponseEntity.ok().body(materialService.create(materialDTO));
    }

    @PutMapping
    public ResponseEntity<String> updateMaterialPrice(UpdateMaterialPriceDTO updateMaterialPriceDTO) {
        materialService.updateMaterialPrice(updateMaterialPriceDTO);
        return ResponseEntity.ok().body("Preço do material atualizado com sucesso.");
    }
}
