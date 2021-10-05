package com.journeyfy.journeyfytravelapplication.components.posts;


import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.exception.domain.EntityNotFoundException;
import com.journeyfy.journeyfytravelapplication.exception.domain.PostExistsException;
import com.journeyfy.journeyfytravelapplication.exception.domain.UserNotFoundException;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final EntityRepository entityRepository;


    public List<Post> findPostsByEntity(String entityId) {
        Entity entityFound = entityRepository.findEntityById(entityId);
        return postRepository.findAllByEntity(entityFound);
    }

    public Post saveNewPost(Post post, Long userId, String entityId) throws PostExistsException, UserNotFoundException, EntityNotFoundException {
        User currentUser = userRepository.findUserById(userId);
        Entity currentEntity = entityRepository.findEntityById(entityId);
        if(postRepository.existsByEntityAndUser(currentEntity, currentUser)){
            throw new PostExistsException("You cannot post twice to the same activity!");
        }
        if (currentUser == null) {
            throw new UserNotFoundException("No user found by id: " + userId + "!");
        }
        if(currentEntity == null){
            throw new EntityNotFoundException("No entity found by id: " + entityId + "!");
        }
        Post newPost = new Post();
        newPost.setTitle(post.getTitle());
        newPost.setText(post.getText());
        newPost.setEntity(currentEntity);
        newPost.setUser(currentUser);
        newPost.setRating(post.getRating());
        newPost.setPostedAt(LocalDate.now());
        postRepository.save(newPost);
        currentEntity.calculateReview();
        entityRepository.save(currentEntity);
        return newPost;
    }


}
