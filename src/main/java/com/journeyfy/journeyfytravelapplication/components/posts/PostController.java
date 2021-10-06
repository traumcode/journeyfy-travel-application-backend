package com.journeyfy.journeyfytravelapplication.components.posts;



import com.journeyfy.journeyfytravelapplication.exception.domain.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class PostController {

    private final PostService postService;


    @GetMapping(path = "/list/{entityId}")
    public List<Post> getAllPostsByEntity(@PathVariable(value = "entityId") String entityId) {
        return postService.findPostsByEntity(entityId);
    }

    @GetMapping(path = "/list-all/{userId}")
    public List<Post> getAllPostsByUser(@PathVariable(value = "userId") Long userId) {
        return postService.findPostsByUser(userId);
    }

    @PostMapping(path = "/new-post/{entityId}/{userId}")
    public ResponseEntity<Post> addNewPost(@PathVariable(value = "entityId") String entityId, @PathVariable(value = "userId") Long userId, @RequestBody Post post) throws PostExistsException, UserNotFoundException, EntityNotFoundException {
        Post newPost = postService.saveNewPost(post, userId, entityId);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }

    @PatchMapping(path = "/edit-post/{postId}")
    public ResponseEntity<Post> editPost(@PathVariable(value = "postId") Long postId, @RequestBody PostDto postDto) throws EntityNotFoundException, UserNotFoundException, PostNotFoundException, PostNotAllowedException {
        Post postToUpdate = postService.editPost(postId, postDto);
        return new ResponseEntity<>(postToUpdate, HttpStatus.OK);
    }
}
