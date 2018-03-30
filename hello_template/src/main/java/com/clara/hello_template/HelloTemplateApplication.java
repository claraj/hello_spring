package com.clara.hello_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Controller
public class HelloTemplateApplication {
    
    
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("author", "Clara");
        
        List favoriteFoods = Arrays.asList("pizza", "tacos", "ice cream");
        model.addAttribute("favoriteFoods", favoriteFoods);
        return "index.html";
    }

	public static void main(String[] args) {
		SpringApplication.run(HelloTemplateApplication.class, args);
	}
}



