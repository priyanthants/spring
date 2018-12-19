package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class Functions {


    @Bean
    public Function<String, String> welcome() {
        return response->"Hai "+response;
    }


    @Bean
    public Supplier<String> helloworld() {
        return this::getText;
    }


    private String getText(){
        return "Hello World";
    }

}
