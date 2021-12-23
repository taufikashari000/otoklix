package com.otoklix.service;

import com.otoklix.dto.PostDto;
import com.otoklix.model.Post;
import com.otoklix.payload.CreatePostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<PostDto> getAllEntities();
    Post getSingleEntity(Long id);
    Post saveNewEntity(CreatePostRequest createPostRequest);
    Post editEntity(Long id, CreatePostRequest createPostRequest);
    Post deleteEntity(Long id);

}
