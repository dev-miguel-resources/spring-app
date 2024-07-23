package com.course.app_medic.controllers;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.course.app_medic.dtos.PatientDTO;
import com.course.app_medic.models.Patient;
import com.course.app_medic.services.IPatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService service;

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    // transformers
    private PatientDTO convertToDto(Patient obj) {
        return mapper.map(obj, PatientDTO.class);
    }

    private Patient convertToEntity(PatientDTO dto) {
        return mapper.map(dto, Patient.class);
    }

    /*
     * @GetMapping
     * public ResponseEntity<List<?>> findAll() {
     * 
     * }
     */

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientDTO dto) {
        Patient obj = service.save(convertToEntity(dto));
        // return new ResponseEntity<>(obj, HttpStatus.CREATED);
        // patientes/1
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /*
     * @GetMapping("/{id}")
     * public ResponseEntity<?> findById() {
     * 
     * }
     */

    /*
     * @PutMapping("/{id}")
     * public ResponseEntity<?> update() {
     * 
     * }
     */

    /*
     * @DeleteMapping("/{id}")
     * public ResponseEntity<?> delete() {
     * 
     * }
     */

    /*
     * @GetMapping("/hateoas/{id}")
     * public ResponseEntity<?> findByHateoas() {
     * 
     * }
     */

    /*
     * @GetMapping("/pageable")
     * public ResponseEntity<?> listByPage() {
     * 
     * }
     */

}
