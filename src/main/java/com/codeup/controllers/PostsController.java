package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    List<Post> posts = new ArrayList<>();
    @GetMapping("posts")
    public String viewAllPosts (Model model) {
        //array list wih several post objs
        posts = new ArrayList<>();
        Post post1 = new Post("title1", "body1");
        Post post2 = new Post("title2", "body2");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        //pass the list to the view (through a view model)
        return "posts/index";
    } // posts/index

    @GetMapping("/posts/{id}")
    public String viewSinglePosts (@PathVariable long id, Model model) {
        String title = "post title";
        String body = "this is a post description";
        //one post obj
        Post post = new Post(title, body);
        posts.add(post);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("body", post.getBody());
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePostForm () {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost () {
        return "create a new post post";
    }
}
