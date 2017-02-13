package com.example.controller;

import com.example.entities.Contacts;
import com.example.entities.Student;
import com.example.entities.User;
import com.example.services.ContactRepository;
import com.example.services.StudentRepository;
import com.example.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by noelaniekan on 1/31/17.
 */
@Controller
public class CodeAfricaTrialController {
    @Autowired
    ContactRepository contacts;
    @Autowired
    UserRepository users;
    @Autowired
    StudentRepository students;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String contacts(Model model){
        List<Contacts> contactsList = (List<Contacts>) contacts.findAll();
        model.addAttribute("contacts", contactsList);

        return "index";
    }

    @RequestMapping(path = "/add-contact", method = RequestMethod.POST)
    public String addContact(String name, String email, String phone){
        Contacts contact = new Contacts(name, email, phone);
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

    @RequestMapping(path = "/contact")
    public String reach() {
        return "index";
    }

    @RequestMapping(path = "add-student", method = RequestMethod.POST)
    public String addStudent(String name, String email, String phone){
        Student student = new Student(name, email, phone);
        students.save(student);
        return "redirect:/";
    }

    @RequestMapping(path = "/student")
    public String student(){
        return "student";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) throws Exception{
        session.setAttribute("username", username);

        User user = users.findOneByName(username);
        if (user == null){
            user = new User();
            user.name = username;
            users.save(user);
        }
        return "redirect:/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String admin(HttpSession session, Model model){
        String userName = (String) session.getAttribute("username");
        User user = users.findOneByName(userName);
        if(user != null){
            model.addAttribute("user", user);
        }
        List<Contacts> contactList;
        contactList = (List<Contacts>) contacts.findAll();
        model.addAttribute("contacts", contactList);

        List<Student> studentList;
        studentList = (List<Student>) students.findAll();
        model.addAttribute("students", studentList);
        return "login";





    }


}
