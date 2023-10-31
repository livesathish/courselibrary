package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.repository.AuthorRepository;
import com.application.courselibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {


    @Autowired
    public AuthorService authorService;


    @GetMapping("/authors")
    public String getAllAuthors(Model model){

        List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("authors",authors);

        return "authors";
    }

    @GetMapping("/remove-authors/{id}")
    public String deleteAuthors(@PathVariable Long id, Model model){

        authorService.deleteAuthor(id);
        model.addAttribute("authors",authorService.findAllAuthors());

        return "authors";
    }

    @GetMapping("/update-authors/{id}")
    public String updateAuthors(@PathVariable Long id, Model model){

        Author author = authorService.findAuthorById(id);
        model.addAttribute("authors",author);

        return "update-authors";
    }

    @PostMapping("update-authors/{id}")
    public String addAuthors(@PathVariable Long id, Author author ,BindingResult result, Model model){

        if(result.hasErrors()){
            return "update-authors";
        }
        authorService.updateAuthor(author);
        model.addAttribute("authors",authorService.findAllAuthors());


        return "redirect:/authors";
    }

    @GetMapping("/add-authors")
    public String addAuthors(Author author,Model model){

//        model.addAttribute("authors",model.addAttribute(author));
        return "add-authors";
    }

    @PostMapping("/save-authors")
    public String saveAuthors(Model model,Author author,BindingResult result){

        if(result.hasErrors()){
            return "add-authors";
        }
        authorService.createAuthor(author);
        model.addAttribute("authors",authorService.findAllAuthors());


        return "authors";
    }


}
