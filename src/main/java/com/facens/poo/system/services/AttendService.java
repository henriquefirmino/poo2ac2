package com.facens.poo.system.services;

import java.util.Optional;

import com.facens.poo.system.dto.AttendDTO;
import com.facens.poo.system.dto.AttendInsertDTO;
import com.facens.poo.system.dto.AttendUpdateDTO;
import com.facens.poo.system.entities.Attend;
import com.facens.poo.system.repositories.AttendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AttendService {
    
    @Autowired
    private AttendRepository repository;

    public AttendDTO getAttendById(Long id) {
        Optional<Attend> op = repository.findById(id);
        Attend attend = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendee not found by id"));
        return new AttendDTO(attend);
    }


    public AttendDTO insertAttend(AttendInsertDTO attendInsertDTO) {

        Attend entity = new Attend(attendInsertDTO);
        entity = repository.save(entity);
        return new AttendDTO(entity);
    }

    public AttendDTO updateAttend(Long id, AttendUpdateDTO updateDTO) {
        return null;
    }

    public void deleteAttend(Long id) {
    }
}
