package com.otoklix.service.serviceimplement;

import com.otoklix.dto.PostDto;
import com.otoklix.model.Post;
import com.otoklix.payload.CreatePostRequest;
import com.otoklix.repository.PostRepository;
import com.otoklix.service.PostService;
import com.otoklix.util.ResourceNotFoundException;
import com.otoklix.util.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostServiceImplement implements PostService {

    private final Logger LOGGER = LoggerFactory.getLogger(PostServiceImplement.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDto> getAllEntities() {
        List<PostDto> results = postRepository.getAllEntities();
        return results;
    }
    @Override
    public Post getSingleEntity(Long id) {
        Post result = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("Entity NOT FOUND")));
        return result;
    }
    @Override
    public Post saveNewEntity(CreatePostRequest createPostRequest) {
        Post result = new Post();
        result.setTitle(createPostRequest.getTitle());
        result.setContent(createPostRequest.getContent());
        result.setPublished_at(postRepository.getSysDate());
        result.setCreated_at(postRepository.getSysDate());
        result.setUpdated_at(postRepository.getSysDate());
        postRepository.save(result);
        return result;
    }
    @Override
    public Post editEntity(Long id, CreatePostRequest createPostRequest) {
        Post result = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("Entity NOT FOUND")));
        result.setId(id);
        result.setTitle(createPostRequest.getTitle());
        result.setContent(createPostRequest.getContent());
        result.setUpdated_at(postRepository.getSysDate());
        postRepository.save(result);
        return result;
    }
    @Override
    public Post deleteEntity(Long id) {
        Post result = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Setting.getErrorString("Entity NOT FOUND")));
        postRepository.deleteById(id);
        return result;
    }
}
