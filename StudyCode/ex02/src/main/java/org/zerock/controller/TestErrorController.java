package org.zerock.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        return "/error/error_page";
    }

    @PostMapping("/notget")
    public String notGet(){
        return "index";
    }

    @GetMapping("/exception")
    public String exception(){
        int i = 1/0;
        return "index";
    }

    @PostMapping("api/notget")
    public String apinotGet(){
        return "get만";
    }

    @GetMapping("/api/exception")
    public String apiexception(){
        int i=1/0;
        return "예외";
    }
}
