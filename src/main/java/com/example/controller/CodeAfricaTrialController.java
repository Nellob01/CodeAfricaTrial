package com.example.controller;

import com.example.entities.Contacts;
import com.example.services.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by noelaniekan on 1/31/17.
 */
@Controller
public class CodeAfricaTrialController {
    @Autowired
    ContactRepository contacts;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String contacts(Model model){
        List<Contacts> contactsList = (List<Contacts>) contacts.findAll();
        model.addAttribute("contacts", contactsList);

        return "index";
    }

    @RequestMapping(path = "/add-contact", method = RequestMethod.POST)
    public String addContact(String contactName, String contactEmail, String contactPhone, String contactComments){
        Contacts contact = new Contacts(contactName, contactEmail, contactPhone, contactComments);
        contacts.save(contact);
        return "redirect:/";
    }
    @RequestMapping(path = "/contacts")
    public String info(){
        return "contacts";
    }

    @RequestMapping(path = "/about")
    public String learn(){
        return "index";
    }

    @RequestMapping(path = "/contactUs")
    public String reach() {
        return "index";
    }

}
