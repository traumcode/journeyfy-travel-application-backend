package com.journeyfy.journeyfytravelapplication.components.posts;

import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByEntity(Entity entity);
    List<Post> findAllByUser(User user);
    boolean existsByEntityAndUser(Entity entity, User user);
}
