package me.yling.roboresumeproject0804.controllers;

import me.yling.roboresumeproject0804.models.Resume;
import me.yling.roboresumeproject0804.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    ResumeRepository resumeRepository;

    @GetMapping("/")
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
    public String postResume (@Valid @ModelAttribute("newResume") Resume resume, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "addresume";
        }

        //save it to the database
        resumeRepository.save(resume);
        return "result";
    }

    @GetMapping("/listresumes")
    public String listResumes (Model model)
    {
        Iterable<Resume> resumeList = resumeRepository.findAll();
        model.addAttribute("resumes", resumeList);
        return"listresumes";
    }







}



