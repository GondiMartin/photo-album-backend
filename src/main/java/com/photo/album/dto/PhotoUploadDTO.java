package com.photo.album.dto;

import com.photo.album.entity.PhotoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PhotoUploadDTO {
    private String name;
    private Date uploadDate;

    public static PhotoUploadDTO toPhotoUploadDTO(PhotoEntity entity){
        if(entity == null){
            return null;
        }
        PhotoUploadDTO photoDTO = new PhotoUploadDTO();
        photoDTO.setName(entity.getName());
        photoDTO.setUploadDate(entity.getUploadDate());

        return photoDTO;
    }
}
