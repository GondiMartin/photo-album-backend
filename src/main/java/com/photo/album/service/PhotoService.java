package com.photo.album.service;

import com.photo.album.dto.PhotoDTO;
import com.photo.album.entity.PhotoEntity;
import com.photo.album.entity.UserEntity;
import com.photo.album.repository.PhotoRepository;
import com.photo.album.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public PhotoEntity upload(PhotoDTO photo) {
        PhotoEntity entity = new PhotoEntity();
        entity.setName(photo.getName());
        entity.setUploadDate(LocalDateTime.now());
        entity.setImage(photo.getImage());
        entity.setUser(userRepository.getReferenceById(photo.getUserId()));
        return photoRepository.save(entity);
    }

    public List<PhotoEntity> getAll(long userId) {
        UserEntity user = userRepository.getReferenceById(userId);
        return photoRepository.getPhotoEntitiesByUserIs(user);
    }

    public void delete(long imageId) {
        photoRepository.deleteById(imageId);
    }
}
