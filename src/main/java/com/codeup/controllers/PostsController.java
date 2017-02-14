package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.Posts;
import com.codeup.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    @Autowired
    Posts postsDao;

    @GetMapping("posts")
    public String viewAllPosts (Model model) {

        for (Post post : postsDao.findByTitle("%yassine%")) {
            System.out.println(post.getTitle());
        }
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    } // posts/index

    @GetMapping("/posts/{id}")
    public String viewSinglePosts (@PathVariable long id, Model model) {
        model.addAttribute("posts", postsDao.findOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm ( Model model) {
        model.addAttribute(new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost (@ModelAttribute Post post, Model model) {
        postsDao.save(post);
        return "/posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postsDao.findOne(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(Model model, @ModelAttribute Post post) {
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postsDao.delete(postsDao.findOne(post.getId()));
        return "redirect:/posts";
    }
}
