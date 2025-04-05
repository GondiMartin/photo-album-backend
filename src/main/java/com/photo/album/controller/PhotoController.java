package com.photo.album.controller;

import com.photo.album.converter.PhotoConverter;
import com.photo.album.dto.PhotoDTO;
import com.photo.album.entity.PhotoEntity;
import com.photo.album.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
@CrossOrigin(origins = "${frontend.url}")
public class PhotoController {

    private final PhotoService service;
    private final PhotoConverter photoConverter;

    @GetMapping()
    public ResponseEntity<List<PhotoDTO>> getAll(@RequestParam long userId) {
        return ResponseEntity.ok(service.getAll(userId).stream().map(photoConverter::convertFromEntityToDTO).toList());
    }

    @PostMapping()
    public ResponseEntity<PhotoDTO> upload(@RequestBody PhotoDTO photo){
        PhotoEntity newPostEntity = service.upload(photo);
        PhotoDTO newPostDTO = photoConverter.convertFromEntityToDTO(newPostEntity);
        return ResponseEntity.ok(newPostDTO);
    }

    @DeleteMapping()
    public void delete(@RequestParam long imageId) {
        service.delete(imageId);
    }
}
