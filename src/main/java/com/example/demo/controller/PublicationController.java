package com.example.demo.controller;

import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PublicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationServiceImpl publicationService;

    public PublicationController(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping
    public ResponseEntity<PublicationEntity> addPublication(@RequestBody PublicationEntity publicationEntity) {
        PublicationEntity newPublication = publicationService.addPublication(publicationEntity);
        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }
}
