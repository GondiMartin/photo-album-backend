package com.photo.album.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {

    private Long id;
    private String name;
    private String uploadDate;
    private Long userId;
    private byte[] image;
}
