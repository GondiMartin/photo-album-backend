package com.photo.album.entity;

import com.photo.album.dto.PhotoUploadDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date uploadDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public static PhotoEntity toPhotoEntity(PhotoUploadDTO photoDTO, UserEntity user){
        if(photoDTO == null){
            return null;
        }
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setName(photoDTO.getName());
        photoEntity.setUploadDate(photoDTO.getUploadDate());
        photoEntity.setUser(user);

        return photoEntity;
    }
}
