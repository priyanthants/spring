package com.example.service.impl;

import com.example.service.WelcomeService;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    public String welcomeUser() {
        return "Hello World";
    }
}
