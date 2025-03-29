package com.photo.album.dto;

import com.photo.album.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private List<PhotoDTO> photos;

    public static UserDTO toUserDTO(UserEntity user){
        if(user == null){
            return null;
        }

        List<PhotoDTO> photosDTO = user.getPhotos().stream().map(PhotoDTO::toPhotoDTO).collect(Collectors.toList());

        return new UserDTO(user.getId(), user.getEmail() , user.getName(), photosDTO);
    }
}
