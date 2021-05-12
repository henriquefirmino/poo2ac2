package com.facens.poo.system.services;

import java.util.Optional;

import com.facens.poo.system.dto.AdminDTO;
import com.facens.poo.system.entities.Admin;
import com.facens.poo.system.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public AdminDTO getEventById(Long id) {
        Optional<Admin> op = repository.findById(id);
        Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found by id"));
        return new AdminDTO(admin);
    }
    
}
