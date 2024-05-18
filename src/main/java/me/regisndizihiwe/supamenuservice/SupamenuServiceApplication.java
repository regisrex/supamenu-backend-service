package me.regisndizihiwe.supamenuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SupamenuServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupamenuServiceApplication.class, args);
    }


    @GetMapping
    public String sayHello(){
        return "Wallo walloo";
    }

}
