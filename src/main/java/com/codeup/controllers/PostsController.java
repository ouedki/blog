package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    PostSvc postSvc;

    @GetMapping("posts")
    public String viewAllPosts (Model model) {
        model.addAttribute("posts", postSvc.findAllPosts());
        return "posts/index";
    } // posts/index

    @GetMapping("/posts/{id}")
    public String viewSinglePosts (@PathVariable int id, Model model) {
        model.addAttribute("posts", postSvc.findOnePost(id));
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
