package com.facens.poo.system.services;

import java.util.Optional;

import com.facens.poo.system.dto.AdminDTO;
import com.facens.poo.system.dto.AdminInsertDTO;
import com.facens.poo.system.dto.AdminUpdateDTO;
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

    public AdminDTO getAdminById(Long id) {
        Optional<Admin> op = repository.findById(id);
        Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found by id"));
        return new AdminDTO(admin);
    }


    public AdminDTO insertAdmin(AdminInsertDTO adminInsertDTO) {

        Admin entity = new Admin(adminInsertDTO);
        entity = repository.save(entity);
        return new AdminDTO(entity);
    }

    public AdminDTO updateAdmin(Long id, AdminUpdateDTO updateDTO) {
        return null;
    }

    public void deleteAdmin(Long id) {
    }

    
}
