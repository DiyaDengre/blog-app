package com.blog.blogging.project.controller;


import com.blog.blogging.project.model.Post;
import com.blog.blogging.project.repository.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    @Autowired
    PostRepo repo;
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("posts", repo.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String createPage() {

        return "create"; // opens create.html
    }
    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";

    }
    @GetMapping("/edit")
    public String editPost(@RequestParam int id, Model model) {
        Post post = repo.findById(id).orElse(null);

        if (post == null) {
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "edit";
    }
    @GetMapping("/delete")
    public String deletePost(@RequestParam int id) {
        repo.deleteById(id);
        return "redirect:/";
    }

}
