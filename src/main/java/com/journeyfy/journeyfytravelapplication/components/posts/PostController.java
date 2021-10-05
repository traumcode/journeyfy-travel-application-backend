package com.journeyfy.journeyfytravelapplication.components.posts;



import com.journeyfy.journeyfytravelapplication.exception.domain.EntityNotFoundException;
import com.journeyfy.journeyfytravelapplication.exception.domain.PostExistsException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "/new-post/{entityId}/{userId}")
    public ResponseEntity<Post> addNewPost(@PathVariable(value = "entityId") String entityId, @PathVariable(value = "userId") Long userId, @RequestBody Post post) throws PostExistsException, UserNotFoundException, EntityNotFoundException {
        Post newPost = postService.saveNewPost(post, userId, entityId);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }
}
