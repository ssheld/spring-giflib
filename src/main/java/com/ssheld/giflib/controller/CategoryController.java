package com.ssheld.giflib.controller;

import com.ssheld.giflib.data.CategoryRepository;
import com.ssheld.giflib.data.GifRepository;
import com.ssheld.giflib.model.Category;
import com.ssheld.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: Stephen Sheldon 3/20/2019
 */

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        // Get all the categories from our repository
        List<Category> allCategories = categoryRepository.getAllCategories();
        // Put all the categories into our ModelMap so that they're accessible by our views
        modelMap.put("categories", allCategories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    // @PathVariable will capture the value passed in to the id placeholder that's in
    // our request mapping annotation.
    public String category(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);

        // Map the category to the ModelMap so our view has access
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);

        modelMap.put("gifs", gifs);

        return "category";
    }
}
