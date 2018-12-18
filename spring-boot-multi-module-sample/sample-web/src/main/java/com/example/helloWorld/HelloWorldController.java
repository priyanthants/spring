package com.example.helloWorld;


import com.example.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private WelcomeService welcomeService;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeService.welcomeUser();
    }
}
