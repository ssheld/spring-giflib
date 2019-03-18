package com.ssheld.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Stephen Sheldon 3/18/2019
 */

@Controller
public class GifController {
    @RequestMapping("/")
    public String listGifs() {
        return "home";
    }

}
