package com.photo.album.controller;

import com.photo.album.dto.PhotoUploadDTO;
import com.photo.album.dto.UserDTO;
import com.photo.album.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService service;


    @GetMapping("/hello")
    public String hello() {
        return "Hello, User!";
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam Long id){
        return ResponseEntity.ok(UserDTO.toUserDTO(service.getUser(id)));
    }

    @PutMapping
    public ResponseEntity<Void> addPhoto(@RequestParam Long userId, @RequestBody PhotoUploadDTO photoToUpload){
        service.addPhoto(userId, photoToUpload);
        return ResponseEntity.ok().build();
    }
}
