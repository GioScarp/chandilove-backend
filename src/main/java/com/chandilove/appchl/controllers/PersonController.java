package com.chandilove.appchl.controllers;

import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persona")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping("/{id}")
    public ResponseEntity<UserPersonDTO> getUserPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
}
