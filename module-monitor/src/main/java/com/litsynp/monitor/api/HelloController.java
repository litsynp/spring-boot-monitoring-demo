package com.litsynp.monitor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    @GetMapping("/{username}")
    public String getHello(@PathVariable String username) {
        return "Hello " + username;
    }
}
