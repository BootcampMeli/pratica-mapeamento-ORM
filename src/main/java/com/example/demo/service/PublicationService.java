package com.example.demo.service;


import com.example.demo.dto.PublicationDTO;
import com.example.demo.entity.PublicationEntity;

public interface PublicationService {

    PublicationEntity addPublication(PublicationDTO publicationEntity);

    PublicationEntity getPublication(Long id);

    void deletePublication(Long id);

    PublicationEntity updatePublication(Long id, PublicationDTO publicationDTO);
}
