package com.codeup.services;

import com.codeup.models.Post;
import com.codeup.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {
    private List<Post> posts = new ArrayList<>();
    public  PostSvc(){
        createPosts();
    }



    public List<Post> findAllPosts (){
        return posts;
    }

    public Post save (Post post) {
        User user = new User();
        user.setId(1);
        post.setUser(user);
        posts.add(post);
        return post;
    }

    public Post findOnePost (int id) {
        return posts.get(id-1);
    }
    private void createPosts() {
        for (int i = 0; i<20; i++ ){
            save(new Post(i+1, "title" +(i+1),"body" + (i+1)));
        }
    }
}
