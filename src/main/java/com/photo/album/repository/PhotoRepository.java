package com.photo.album.repository;

import com.photo.album.entity.PhotoEntity;
import com.photo.album.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    List<PhotoEntity> getPhotoEntitiesByUserIs(UserEntity user);
}
