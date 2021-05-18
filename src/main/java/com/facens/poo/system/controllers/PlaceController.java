package com.facens.poo.system.controllers;

import java.net.URI;

import com.facens.poo.system.dto.PlaceDTO;
import com.facens.poo.system.dto.PlaceInsertDTO;
import com.facens.poo.system.dto.PlaceUpdateDTO;
import com.facens.poo.system.services.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService service;

    @GetMapping("{id}")
    public ResponseEntity<PlaceDTO> getPlaceById(@PathVariable Long id) {
        PlaceDTO dto = service.getPlaceById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PlaceDTO> insert(@RequestBody PlaceInsertDTO insertDTO) {
        PlaceDTO dto = service.insertPlace(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePlace(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PlaceDTO> update(@RequestBody PlaceUpdateDTO updateDTO, @PathVariable Long id) {
        PlaceDTO dto = service.updatePlace(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
    
}
