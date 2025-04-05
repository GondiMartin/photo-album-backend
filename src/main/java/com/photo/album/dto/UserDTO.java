package com.photo.album.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {
    private Long id;
    private String email;
    private List<PhotoDTO> photos;
}
