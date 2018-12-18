package com.example.helloWorld;

import com.example.version.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	 @GetMapping("/welcome")
	 @ApiVersion(1)
	 public String welcome() {
	 	return "Hello World";
	    }

	@GetMapping("/welcome")
	@ApiVersion(2)
	public String newWelcome() {
		return "Hello World !!!";
	}
}
