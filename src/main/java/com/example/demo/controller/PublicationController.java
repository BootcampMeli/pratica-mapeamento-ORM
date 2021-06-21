package com.example.demo.controller;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PublicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationServiceImpl publicationService;

    public PublicationController(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping
    public ResponseEntity<PublicationEntity> addPublication(@RequestBody PublicationDTO publicationDTO) {
        PublicationEntity newPublication = publicationService.addPublication(publicationDTO);
        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PublicationEntity> getPublication(@PathVariable Long id) {
        PublicationEntity publicationEntity = publicationService.getPublication(id);
        return new ResponseEntity<>(publicationEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<PublicationEntity> updatePublication(@PathVariable Long id, @RequestBody PublicationDTO publicationDTO) {
        PublicationEntity updatedPublication = publicationService.updatePublication(id, publicationDTO);
        return new ResponseEntity<>(updatedPublication, HttpStatus.OK);
    }
}
