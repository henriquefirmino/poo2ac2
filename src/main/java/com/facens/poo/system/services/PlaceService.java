package com.facens.poo.system.services;

import java.util.Optional;

import com.facens.poo.system.dto.PlaceDTO;
import com.facens.poo.system.entities.Place;
import com.facens.poo.system.repositories.PlaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repository;
    
    public PlaceDTO getPlaceById(Long id) {
        Optional<Place> op = repository.findById(id);
        Place place = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found by id"));
        return new PlaceDTO(place);
    }
}
