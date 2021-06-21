package com.example.demo.service;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.PublicationRepository;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;
    private final UserService userService;

    public PublicationServiceImpl(PublicationRepository publicationRepository, UserService userService) {
        this.publicationRepository = publicationRepository;
        this.userService = userService;
    }

    @Override
    public PublicationEntity addPublication(PublicationDTO publicationDTO) {
        long userId = publicationDTO.getUserId();
        UserEntity userEntity = userService.findById(userId);

        PublicationEntity publicationEntity = new PublicationEntity();
        publicationEntity.setText(publicationDTO.getText());
        publicationEntity.setUserEntity(userEntity);

        return publicationRepository.save(publicationEntity);
    }

    @Override
    public PublicationEntity getPublication(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    @Override
    public PublicationEntity updatePublication(Long id, PublicationDTO publicationDTO) {
        PublicationEntity publicationEntity = publicationRepository.findById(id).get();
        publicationEntity.setText(publicationDTO.getText());

        return publicationRepository.save(publicationEntity);
    }
}
