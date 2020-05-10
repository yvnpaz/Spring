package guru.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping({"","/", "index", "index.html"})
    public String index(){
        System.out.println("Index Pet Clinic");
        return "index";
    }

    @RequestMapping("/oups")
    public String ooops(){
        return "notimplemented";
    }

}
