package com.example.demo.service;

import com.example.demo.entity.PublicationEntity;
import com.example.demo.repository.PublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public PublicationEntity addPublication(PublicationEntity publicationEntity) {
        return publicationRepository.save(publicationEntity);
    }
}
