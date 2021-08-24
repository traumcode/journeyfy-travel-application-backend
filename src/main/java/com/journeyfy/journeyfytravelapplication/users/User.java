package com.journeyfy.journeyfytravelapplication.users;


import com.journeyfy.journeyfytravelapplication.posts.Post;
import com.journeyfy.journeyfytravelapplication.wishes.Wish;

import java.util.List;

public class User {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private List<Post> posts;
    private List<Wish> favorites;

}
