package com.facens.poo.system.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.facens.poo.system.dto.PlaceInsertDTO;

@Entity
@Table(name = "TB_PLACE")
public class Place implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    
    public Place(PlaceInsertDTO placeInsertDTO) {
        this.name = placeInsertDTO.getName();
        this.address = placeInsertDTO.getAddress();        
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    
}
