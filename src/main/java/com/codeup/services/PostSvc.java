package com.codeup.services;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {
    private List<Post> posts = new ArrayList<>();
    private Posts repository;

    public List<Post> findAllPosts (){
        return posts;
    }

    public Post save (Post post) {
        repository.save(post);
        return post;
    }

    public Post findOnePost (int id) {
        return posts.get(id-1);
    }

}
