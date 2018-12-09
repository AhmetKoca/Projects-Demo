package com.akoca.mvc.controller;

import com.akoca.mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    /*added*/
    @Value("#{countryOptions}")
    private Map<String , String> countryOptions;
    /*added*/

    @Value("#{opSystemOptions}")
    private Map<String , String> opSystemOptions;

    @RequestMapping("/sendForm")
    public String displayTheForm(Model model) {

        Student theStudent = new Student();
        model.addAttribute("theStudent" , theStudent);

        /*added*/
        model.addAttribute("theCountryOptions" , countryOptions);
        /*added*/

        model.addAttribute("theOSOptions" , opSystemOptions);

        return "student-form";
    }

    @RequestMapping("/processStudentForm")
    public String processForm(
            @Valid @ModelAttribute("theStudent") Student theStudent ,
            BindingResult bindingResult ,
            Model model
    ) {

        System.out.println("the student: " + theStudent);

        /*added*/
        model.addAttribute("theCountryOptions" , countryOptions);
        /*added*/

        model.addAttribute("theOSOptions" , opSystemOptions);

        if(bindingResult.hasErrors()) {
            return "student-form";
        } else {
            return "student-confirmation";
        }
    }
}