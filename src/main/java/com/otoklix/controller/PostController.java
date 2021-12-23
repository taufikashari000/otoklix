package com.otoklix.controller;

import com.otoklix.dto.PostDto;
import com.otoklix.model.Post;
import com.otoklix.payload.CreatePostRequest;
import com.otoklix.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<?> getAllEntities() {
        List<PostDto> results = postService.getAllEntities();
        return ResponseEntity.ok(results);
    }
    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<?> getSingleEntity(@PathVariable("id") Long id) {
        Post result = postService.getSingleEntity(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(value = "/posts")
    public ResponseEntity<?> saveNewEntity(@Valid @RequestBody CreatePostRequest createPostRequest) {
        Post result = postService.saveNewEntity(createPostRequest);
        return ResponseEntity.ok(result);
    }
    @PutMapping(value = "/posts/{id}")
    public ResponseEntity<?> editEntity(@PathVariable("id") Long id,
                                        @Valid @RequestBody CreatePostRequest createPostRequest) {
        Post result = postService.editEntity(id, createPostRequest);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping(value = "/posts/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable("id") Long id) {
        Post result = postService.deleteEntity(id);
        return ResponseEntity.ok(result);
    }
}