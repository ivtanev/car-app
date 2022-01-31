package com.example.demo.controller;

import com.example.demo.dto.OwnerDto;
import com.example.demo.model.Owner;
import com.example.demo.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    ResponseEntity<OwnerDto> findById(@PathVariable(value = "id")Long id){
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if(optionalOwner.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        OwnerDto mappedDto = modelMapper.map(optionalOwner.get(), OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PostMapping
    ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto newOwner){
        Owner owner = modelMapper.map(newOwner, Owner.class);
        Owner createdOwner = ownerService.saveOwner(owner);
        OwnerDto mappedDto = modelMapper.map(createdOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<OwnerDto> editOwner(@Valid @RequestBody OwnerDto editOwner, @PathVariable(value = "id") Long id){
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if(optionalOwner.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Owner owner = modelMapper.map(editOwner, Owner.class);
        owner.setId(id);
        Owner editedOwner = ownerService.saveOwner(owner);
        OwnerDto mappedDto = modelMapper.map(editedOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<OwnerDto> deleteOwner(@PathVariable(value = "id")Long id){
        Optional<Owner> optionalOwner = ownerService.findById(id);
        if(optionalOwner.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        OwnerDto mappedDto = modelMapper.map(optionalOwner.get(), OwnerDto.class);
        ownerService.deleteOwner(id);
        return ResponseEntity.ok(mappedDto);
    }
}
