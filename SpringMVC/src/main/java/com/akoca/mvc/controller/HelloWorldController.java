package com.akoca.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @RequestMapping("/sendHelloWorldForm")
    public String helloWorldFormSender() {
        return "helloWorldForm";
    }

    @RequestMapping("/sendHelloWorldPage")
    public String helloWorldPageSender() {
        return "helloWorldPage";
    }

    @RequestMapping("/processFormUsingModel")
    public String sendDataUsingModel(HttpServletRequest request , Model model) {

        String userName = request.getParameter("userName");

        String result = request.getParameter("userName").toUpperCase()
                + request.getParameter("userSurname").toUpperCase();

        model.addAttribute("upperCasedName" , result);

        return "helloWorldPage";
    }

    @RequestMapping("/processFormUsingModelUseRequestParam")
    public String sendDataUsingModelUseRequestParam(@RequestParam("userName")String userName ,
                                                    @RequestParam("userSurname")String userSurname ,
                                                    Model model) {

        String result = userName.toUpperCase() + " "
                + userSurname.toUpperCase();

        model.addAttribute("upperCasedName" , result);

        return "helloWorldPage";
    }
}