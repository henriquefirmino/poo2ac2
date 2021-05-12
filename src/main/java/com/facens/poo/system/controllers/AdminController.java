package com.facens.poo.system.controllers;

import com.facens.poo.system.dto.AdminDTO;
import com.facens.poo.system.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
