package com.ssheld.giflib.controller;
import com.ssheld.giflib.data.GifRepository;
import com.ssheld.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: Stephen Sheldon 3/18/2019
 */

@Controller
public class GifController {

    // Instructs Spring, as soon as it's needed, to auto-assign our field
    // as long as the component we're referring to is a component of the same field.
    @Autowired
    private GifRepository gifRepository = new GifRepository();

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    // Add it to a ModelMap so that we can add it to the gif-details view.
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        // Add our gif to the ModelMap object that was passed in.
        modelMap.put("gif", gif);
        // There is no need to return the ModelMap as the Spring Framework will
        // make it available to the templating engine.
        return "gif-details";
    }

}
