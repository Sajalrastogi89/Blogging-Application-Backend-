package com.application.blogging_application.services;

import com.application.blogging_application.payloads.CategoryDTO;

import java.util.List;

public interface CategoryRepo {
    //Create

    public CategoryDTO createCategory(CategoryDTO categoryDTO);


    //Update
    public CategoryDTO updateCategoty(CategoryDTO categoryDTO);
    //Delete
    public void deleteCategoryById(Integer categoryId);
    //Get
    public CategoryDTO getById(Integer categoryId);
    //GetAll
    public List<CategoryDTO> getAllCategory();




}
