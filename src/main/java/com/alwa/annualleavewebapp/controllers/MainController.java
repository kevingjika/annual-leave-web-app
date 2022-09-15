package com.alwa.annualleavewebapp.controllers;

import com.alwa.annualleavewebapp.entities.Application;
import com.alwa.annualleavewebapp.entities.User;
import com.alwa.annualleavewebapp.services.ApplicationService;
import com.alwa.annualleavewebapp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    ApplicationService applicationService;

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @PostMapping("/create/user")
    public ResponseEntity<User> createUser (@RequestBody User user) throws Exception {

        log.info(user.getUsername());
        log.info(user.getFirstname());
        log.info(user.getLastname());
        log.info(user.getEmail());
        log.info(user.getPassword());
        log.info(user.getAddress());

        User savedUser = userService.createUser(user);

        return new ResponseEntity (savedUser, HttpStatus.OK);

    }

    @PutMapping("/edit/user")
    public ResponseEntity<User> editUser (@RequestBody User user, @RequestParam long id) throws Exception {
        user.setId(id);
        User updatedUser = userService.editUser(user);
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/user")
    public ResponseEntity<User> deleteUser(@RequestParam(name = "id") long id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity("User deleted successfully.", HttpStatus.OK);
    }

    @PostMapping("/create/application")
    public ResponseEntity<Application> createApplication(@RequestBody Application application) throws Exception {
        Application savedApplication = applicationService.createApplication(application);
        return new ResponseEntity(savedApplication, HttpStatus.OK);
    }

    @PutMapping("/edit/application")
    public ResponseEntity<Application> editApplication(@RequestBody Application application, @RequestParam long id) throws Exception {
        application.setId(id);
        Application updatedApplication = applicationService.editApplication(application);
        return new ResponseEntity(updatedApplication, HttpStatus.OK);
    }

    @DeleteMapping("/delete/application")
    public ResponseEntity<Application> deleteApplication(@RequestParam(name = "id") long id) throws Exception {
        applicationService.deleteApplication(id);
        return new ResponseEntity("Application deleted successfully.", HttpStatus.OK);
    }


    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "register_success";
    }

    @Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


}