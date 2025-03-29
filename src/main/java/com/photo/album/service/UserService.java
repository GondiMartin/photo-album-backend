package com.photo.album.service;

import com.photo.album.dto.PhotoUploadDTO;
import com.photo.album.entity.PhotoEntity;
import com.photo.album.entity.UserEntity;
import com.photo.album.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserEntity getUser(Long id){
        return repository.findById(id).orElse(null);
    }

    public void addPhoto(Long userId, PhotoUploadDTO photoToUpload) {
        UserEntity user = repository.findById(userId).orElseThrow();

        user.getPhotos().add(PhotoEntity.toPhotoEntity(photoToUpload, user));

        repository.save(user);
    }
}
