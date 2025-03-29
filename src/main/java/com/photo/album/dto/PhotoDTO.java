package com.photo.album.dto;

import com.photo.album.entity.PhotoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {

    private Long id;
    private String name;
    private Date uploadDate;
    private Long userId;

    public static PhotoDTO toPhotoDTO(PhotoEntity entity){
        if(entity == null){
            return null;
        }

        return new PhotoDTO(entity.getId(), entity.getName(), entity.getUploadDate(), entity.getUser().getId());
    }
}
