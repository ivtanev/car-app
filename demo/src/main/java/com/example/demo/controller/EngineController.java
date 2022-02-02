package com.example.demo.controller;

import com.example.demo.dto.EngineDto;
import com.example.demo.model.Engine;
import com.example.demo.service.EngineService;
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
@RequestMapping("/engines")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    ResponseEntity<EngineDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Engine> optionalEngine = engineService.findById(id);
        if(optionalEngine.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        EngineDto mappedDto = modelMapper.map(optionalEngine.get(), EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PostMapping
    ResponseEntity<EngineDto> createEngine(@Valid @RequestBody EngineDto newEngine){
        Engine engine = modelMapper.map(newEngine, Engine.class);
        Engine createdEngine = engineService.saveEngine(engine);
        EngineDto mappedDto = modelMapper.map(createdEngine, EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<EngineDto> editEngine(@Valid @RequestBody EngineDto editEngine, @PathVariable(value = "id") Long id){
        Optional<Engine> optionalEngine = engineService.findById(id);
        if(optionalEngine.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Engine engine = modelMapper.map(editEngine, Engine.class);
        engine.setId(id);
        Engine editedEngine = engineService.saveEngine(engine);
        EngineDto mappedDto = modelMapper.map(editedEngine, EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<EngineDto> deleteEngine(@PathVariable(value = "id") Long id){
        Optional<Engine> optionalEngine = engineService.findById(id);
        if(optionalEngine.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        EngineDto mappedDto = modelMapper.map(optionalEngine.get(), EngineDto.class);
        engineService.deleteEngine(id);
        return ResponseEntity.ok(mappedDto);
    }

}
