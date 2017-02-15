package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
import com.codeup.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;


@Controller
public class PostsController {
    @Autowired
    Posts postsDao;
    @Value("${uploads}")
    private  String uploadPath;

    @Autowired
    UserSvc userSvc;

    @GetMapping("posts")
    public String viewAllPosts (Model model) {

        for (Post post : postsDao.findByTitle("%yassine%")) {
            System.out.println(post.getTitle());
        }
        model.addAttribute("posts", Collections.emptyList());
        return "posts/index";
    } // posts/index

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retvieveAllPosts() {
        return (List<Post>) postsDao.findAll();
    }

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
    public String createPost (@Valid Post post, Errors validation, Model model,  @RequestParam(name = "image_file") MultipartFile uploadedFile) {

        if(validation.hasErrors()){
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "posts/create";
        }

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();

        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userSvc.loggedInUser());
        post.setImage(filename);
        postsDao.save(post);
        return "redirect:/posts";
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
