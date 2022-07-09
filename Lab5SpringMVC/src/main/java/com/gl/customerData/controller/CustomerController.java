package com.gl.customerData.controller; 

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.gl.customerData.entity.Customer;
import com.gl.customerData.service.CustomerService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller 
@RequestMapping({ "/customer" })
public class CustomerController
{
    @Autowired
    private CustomerService ss;
    
    @RequestMapping({ "/list" })
    public String findAll(final Model model) {
        final List<Customer> customerList = (List<Customer>)this.ss.findAllCustomer();
        model.addAttribute("cust", (Object)customerList);
        return "customer";
    }
    
    @RequestMapping({ "/gl" })
    public String goHome() {
        return "return";
    }
    
    @RequestMapping({ "/addcustomer" })
    public String findById(@RequestParam("id") final Integer id, final Model model) {
        if (id != -1) {
            System.out.println("id is: " + id);
            final Customer s = this.ss.findById(id);
            System.out.println(s);
            model.addAttribute("addNewCust", (Object)s);
        }
        else {
            final Customer newcust = new Customer();
            newcust.setId(Integer.valueOf(-1));
            System.out.println("id is :" + newcust.getId());
            model.addAttribute("addNewCust", (Object)newcust);
        }
        return "update";
    }
    
    @RequestMapping({ "/save" })
    public String save(@RequestParam("id") final Integer id, @RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName, @RequestParam("email") final String email) {
        System.out.println("id is" + id);
        Customer s = null;
        if (id != -1) {
            s = this.ss.findById(id);
            s.setFirstName(firstName);
            s.setLastName(lastName);
            s.setEmail(email);
        }
        else {
            s = new Customer(firstName, lastName, email);
        }
        this.ss.save(s);
        return "redirect:list";
    }
    
    @RequestMapping({ "/delete" })
    public String deletecustomer(@RequestParam("id") final Integer id) {
        Customer s = null;
        System.out.println(s);
        s = this.ss.findById(id);
        this.ss.remove(s);
        return "redirect: list";
    }
    
    @RequestMapping({ "/search" })
    public String searchBook(@RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName, @RequestParam("country") final String country, final Model model) {
        final List<Customer> customerList = (List<Customer>)this.ss.findByParam(firstName, lastName, country);
        if (customerList.size() != 0) {
            model.addAttribute("cust", (Object)customerList);
        }
        else {
            model.addAttribute("error", (Object)"No Book Found");
        }
        return "customer";
    }
}