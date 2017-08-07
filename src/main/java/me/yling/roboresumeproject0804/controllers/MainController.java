package me.yling.roboresumeproject0804.controllers;

/*Write a program that will allow a user to enter in:
a name, an email address, an organisation, start date, end date
When the user is done entering the information, calculate the period (in days) for which the user has been employed.
 */

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@Controller
public class MainController {

    @Autowired
    ResumeRepository resumeRepository;

    //create a home page
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
    public String postResume (@Valid @ModelAttribute("newResume") Resume resume, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
            return "addresume";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d1 = LocalDate.parse(resume.getStdate(), formatter);

        //If the user does not enter an end date, use the current date as the end date
        if (resume.getEndate().isEmpty())
        {
            resume.setEndate(String.valueOf(LocalDate.now()));
            resume.setDiffDays(ChronoUnit.DAYS.between(d1, LocalDate.now()));
        } else
        {
            LocalDate d2 = LocalDate.parse(resume.getEndate(), formatter);
            resume.setDiffDays(ChronoUnit.DAYS.between(d1, d2));
        }

        //save it to the database
        resumeRepository.save(resume);
        return "result";
    }

    //Retrieve a list of entries from the database and display them
    @GetMapping("/listresumes")
    public String listResumes (Model model)
    {
        Iterable<Resume> resumeList = resumeRepository.findAll();
        model.addAttribute("resumes", resumeList);
        return"listresumes";
    }

}



