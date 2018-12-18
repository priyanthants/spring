package com.example.helloWorld;

import com.example.modal.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> welcome() {
        return productService.findAllProducts();
    }
}
