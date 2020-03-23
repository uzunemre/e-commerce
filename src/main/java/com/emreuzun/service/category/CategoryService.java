package com.emreuzun.service.category;

import com.emreuzun.model.category.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> getAllByOrder();

    Category getWithProducts(Long categoryId);

    Category getBySeoPath(String seoPath);

}
