package com.journeyfy.journeyfytravelapplication.components.posts;


import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.exception.domain.*;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<Post> findPostsByUser(Long userId){
        User userFound = userRepository.findUserById(userId);
        return postRepository.findAllByUser(userFound);
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
        newPost.setPostedAt(LocalDateTime.now());
        newPost.setActivityType(currentEntity.getActivityType());
        postRepository.save(newPost);
        currentEntity.calculateReview();
        entityRepository.save(currentEntity);
        return newPost;
    }

    public Post editPost(Long postId, PostDto postDto) throws EntityNotFoundException, UserNotFoundException, PostNotFoundException, PostNotAllowedException {
        Entity entityToSet = entityRepository.findEntityById(postDto.getEntityId());
        User userToSet = userRepository.findUserById(postDto.getUserId());
        Post postToUpdate = postRepository.findPostById(postId);
        Long userIdToCheck = postToUpdate.getUser().getId();

        if(!userIdToCheck.equals(postDto.getUserId())){
            throw new PostNotAllowedException("You are not allowed to edit this post");
        }

        if(entityToSet == null){
            throw new EntityNotFoundException("No entity found by id: " + postDto.getEntityId() + "!");
        }

        if(userToSet == null){
            throw new UserNotFoundException("No user found by id: " + postDto.getUserId() + "!");
        }

        postToUpdate.setTitle(postDto.getTitle());
        postToUpdate.setText(postDto.getText());
        postToUpdate.setEntity(entityToSet);
        postToUpdate.setPostedAt(postToUpdate.getPostedAt());
        postToUpdate.setEditedAt(LocalDateTime.now());
        postToUpdate.setLikes(postToUpdate.getLikes());
        postToUpdate.setUser(userToSet);
        postToUpdate.setRating(postDto.getRating());
        postToUpdate.setActivityType(entityToSet.getActivityType());
        postRepository.save(postToUpdate);
        entityToSet.calculateReview();
        entityRepository.save(entityToSet);
        return  postToUpdate;
    }


}
