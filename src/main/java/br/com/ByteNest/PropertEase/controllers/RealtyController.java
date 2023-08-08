package br.com.ByteNest.PropertEase.controllers;

import br.com.ByteNest.PropertEase.models.realty.*;
import br.com.ByteNest.PropertEase.services.RealtyServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("realty")
public class RealtyController {

    @Autowired
    private RealtyServices realtyServices;

    @PostMapping
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Validated RegisterRealtyData data) {
        return realtyServices.register(data);
    }

    @GetMapping
    public ResponseEntity<Page<Realty>> getAll(@RequestParam(defaultValue = "0") int page) {
        return realtyServices.getAll(page);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getRealtyById(@PathVariable UUID id) {
        return realtyServices.getRealtyById(id);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<String> updateFullRealty(@PathVariable UUID id, @RequestBody RegisterRealtyData data) {
        return realtyServices.updateFullRealty(id, data);
    }

    @PutMapping("/update_status/{id}")
    @Transactional
    public ResponseEntity<String> updateRealtyStatus(@PathVariable UUID id, @RequestBody RegisterRealtyData data) {
        return realtyServices.updateRealtyStatus(id, data);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteRealty(@PathVariable UUID id) {
        return realtyServices.deleteRealty(id);
    }
}


