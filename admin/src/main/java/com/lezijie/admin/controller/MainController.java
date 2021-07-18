package com.lezijie.admin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("index")
    @ResponseBody
    public String index(){

        return "你好，欢迎光临";
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
