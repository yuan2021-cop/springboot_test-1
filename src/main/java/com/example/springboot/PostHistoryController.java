package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostHistoryController {

    @Autowired
    private Environment env;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/api")
    public String postString(@RequestParam("post_input_text") String inputTest,
                             Model model) {
        model.addAttribute("title","Post Page");
        System.out.println(inputTest);
        String pathToLoggFile = env.getProperty("post.log.file");
        System.out.println(pathToLoggFile);
        return "index";
    }


    @RequestMapping(value = "/history")
    public String getHistoryString(Model model) {
        String pathToLoggFile = env.getProperty("post.log.file");
        System.out.println(pathToLoggFile);
        model.addAttribute("newLineChar", '\n');
        return "history";
    }

}

