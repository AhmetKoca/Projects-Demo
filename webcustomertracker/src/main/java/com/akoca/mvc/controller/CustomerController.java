package com.akoca.mvc.controller;

import com.akoca.mvc.entity.Customer;
import com.akoca.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customerList = customerService.getCustomers();

        model.addAttribute("customers" , customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute("theCustomer" , customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("theCustomer") Customer customer) {

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerID")int id ,
                                    Model model) {
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("theCustomer" , customer);

        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerID")int id) {
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }
}
