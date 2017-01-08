package com.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Chiranjeevi on 1/3/2017.
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Chiranjeevi");
        return "index";
    }
}
