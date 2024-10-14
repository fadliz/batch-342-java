package com.xa.batch342;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

}
