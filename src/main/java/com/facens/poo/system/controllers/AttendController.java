package com.facens.poo.system.controllers;

import java.net.URI;

import com.facens.poo.system.dto.AttendDTO;
import com.facens.poo.system.dto.AttendInsertDTO;
import com.facens.poo.system.dto.AttendUpdateDTO;
import com.facens.poo.system.services.AttendService;

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
@RequestMapping("/attendees")
public class AttendController {

    @Autowired
    private AttendService service;

    @GetMapping("{id}")
    public ResponseEntity<AttendDTO> getAttendById(@PathVariable Long id) {
        AttendDTO dto = service.getAttendById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<AttendDTO> insert(@RequestBody AttendInsertDTO insertDTO) {
        AttendDTO dto = service.insertAttend(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAttend(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AttendDTO> update(@RequestBody AttendUpdateDTO updateDTO, @PathVariable Long id) {
        AttendDTO dto = service.updateAttend(id, updateDTO);
        return ResponseEntity.ok().body(dto);
    }
    
}
