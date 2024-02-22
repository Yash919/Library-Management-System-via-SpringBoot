package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String listAuthors(Model model){
        model.addAttribute("authors",authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id,Model model){
        authorService.deleteAuthor(id);
        model.addAttribute("authors",authorService.findAllAuthors());
        return "authors";
    }

    @GetMapping("update-author/{id}")
    public String updateAuthor(@PathVariable Long id,Model model){
        model.addAttribute("author",authorService.findAuthorById(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String saveUpdateAuthor(@PathVariable Long id, Author author,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "update-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("author",authorService.findAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String createAuthor(Author author){
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author,BindingResult bindingResult,Model model){
        // Note** while taking parameters Model should be taken after the Binding Result in both update and create case
        // In Spring MVC, when you have a controller method that handles form submissions or data binding, you typically have parameters for the model attribute, followed by BindingResult to capture validation errors. The error suggests that the BindingResult parameter is not positioned correctly.
        if(bindingResult.hasErrors()){
            return "add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("author",authorService.findAllAuthors());
        return "redirect:/authors";
    }

}
