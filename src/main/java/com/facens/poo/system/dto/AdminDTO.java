package com.facens.poo.system.dto;

import com.facens.poo.system.entities.Admin;

public class AdminDTO {

    private Long id;
    private String phoneNumber;

    public AdminDTO() {

    }

    public AdminDTO(Long id, String phoneNumber) {
        setId(id);
        setPhoneNumber(phoneNumber);
    }

    public AdminDTO(Admin admin) {
        setId(admin.getId());
        setPhoneNumber(admin.getPhoneNumber());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    
}
