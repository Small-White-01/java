package com.lezijie.lego.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class MainController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
    @RequestMapping("main")
    public String main(){
        return "main";
    }

}
