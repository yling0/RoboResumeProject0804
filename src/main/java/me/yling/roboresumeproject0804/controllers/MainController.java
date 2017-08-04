package me.yling.roboresumeproject0804.controllers;

import me.yling.roboresumeproject0804.models.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String showIndex(Model model)
    {
        String myMessage = "Welcome to Robo Resume!";
        model.addAttribute("welcomemessage",myMessage);
        return "index";
    }

    @GetMapping("/addresume")
    public String addResume(Model model)
    {
        model.addAttribute("newResume", new Resume());
        model.addAttribute("addresumemessage","Add your resume here");
        return "addresume";
    }

    @PostMapping("/addresume")
    public String postResume (@ModelAttribute("newResume") Resume resume)
    {

        return "result";
    }







}


