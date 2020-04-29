package guru.springframework.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexController(){
        System.out.println("Some message to say...123");
        return "index";
    }
}
