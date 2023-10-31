package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    public PublisherService publisherservice;

    @GetMapping("/publishers")
    public String findAllPublisher(Model model){
        List<Publisher> allPublishers = publisherservice.findAllPublishers();
        model.addAttribute("publishers",allPublishers);

        return "publishers";
    }

    @GetMapping("/add-publishers")
    public String showCreatePublisher(Publisher publisher ){

        return"add-publisher";
    }

    @PostMapping("/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result, Model model ){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherservice.createPublisher(publisher);
        model.addAttribute("publishers",publisherservice.findAllPublishers());
        return"redirect:/publishers";
    }

    @GetMapping("/remove-publishers/{id}")
    public String removePublishers(@PathVariable Long id,Model model){
        publisherservice.deletePublisher(id);
        model.addAttribute("publishers",publisherservice.findAllPublishers());
        return "publishers";
    }

    @GetMapping("update-publishers/{id}")
    public String updatePublishers(@PathVariable Long id,Model model){

        Publisher publisher = publisherservice.findPublishersById(id);
        model.addAttribute("publisher",publisher);

        return "update-publishers";
    }

    @PostMapping("update-publisher/{id}")
    public String savePublisher(@PathVariable Long id,Publisher publisher, BindingResult result,Model model){
        if(result.hasErrors()){
            return "update-publishers";
        }
        publisherservice.updatePublisher(publisher);
        model.addAttribute("publishers",publisherservice.findAllPublishers());

        return "redirect:/publishers";
    }


}
