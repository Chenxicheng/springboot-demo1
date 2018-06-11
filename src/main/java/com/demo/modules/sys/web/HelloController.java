package com.demo.modules.sys.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/hello")
public class HelloController {

    @RequestMapping(value="say")
    public String say (String message) {

        return message;
    }


}
