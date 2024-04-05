package com.humanedu.searchfood.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SPAPageController {
    @GetMapping("/page/main")
    public ModelAndView pageMain(){
        return new ModelAndView("main"); // main.html 파일로 이동
    }

    @GetMapping("/page/main2")
    public ModelAndView pageMain2(){
        return new ModelAndView("main2"); // main.html 파일로 이동
    }

}
