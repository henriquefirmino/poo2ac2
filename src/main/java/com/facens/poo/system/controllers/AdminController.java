package com.facens.poo.system.controllers;

import java.net.URI;

import com.facens.poo.system.dto.AdminDTO;
import com.facens.poo.system.dto.AdminInsertDTO;
import com.facens.poo.system.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/admins")
public class AdminController {
    
    @Autowired
    private AdminService service;

    @GetMapping("{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id) {
        AdminDTO dto = service.getAdminById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> insert(@RequestBody AdminInsertDTO insertDTO) {
        AdminDTO dto = service.insertAdmin(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Lond id) {
        service.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
