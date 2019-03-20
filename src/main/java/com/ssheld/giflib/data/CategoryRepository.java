package com.ssheld.giflib.data;

import com.ssheld.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Stephen Sheldon 3/20/2019
 */

@Component
public class CategoryRepository {
    private List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "People"),
            new Category(2, "Technology"),
            new Category(3, "Humor")
    );

    public Category findById(int categoryId) {
        for (Category category : ALL_CATEGORIES) {
            if (category.getId() == categoryId)
                return category;
        }
        return null;
    }

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}
