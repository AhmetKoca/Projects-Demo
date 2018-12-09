package com.akoca.mvc.controller;

import com.akoca.mvc.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void doInitBinding(WebDataBinder webDataBinder) {

        webDataBinder.registerCustomEditor(String.class , new StringTrimmerEditor(true));
    }

    @RequestMapping("/sendCustomerForm")
    public String sendForm(Model model) {
        model.addAttribute("theCustomer" , new Customer());

        return "customer-form";
    }

    @RequestMapping("/processCustomerForm")
    public String processCustomerData(
            @Valid @ModelAttribute("theCustomer") Customer theCustomer ,
            BindingResult bindingResult
    ) {

        System.out.println("Binding result: " + bindingResult);
        System.out.println();
        System.out.println();

        if(bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}