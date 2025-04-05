package com.photo.album.converter;

import com.photo.album.dto.PhotoDTO;
import com.photo.album.entity.PhotoEntity;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;

@Component
public class PhotoConverter implements IGenericConverter<PhotoEntity, PhotoDTO> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    @Override
    public PhotoDTO convertFromEntityToDTO(PhotoEntity entity) {
        return new PhotoDTO(
                entity.getId(),
                entity.getName(),
                entity.getUploadDate().format(formatter),
                entity.getUser().getId(),
                entity.getImage()
        );
    }
}
