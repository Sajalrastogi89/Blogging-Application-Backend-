package com.application.blogging_application.services.Impl;

import com.application.blogging_application.entities.Category;
import com.application.blogging_application.exceptions.ResourceNotFoundException;
import com.application.blogging_application.payloads.CategoryDTO;
import com.application.blogging_application.repositories.CategoryRepo;
import com.application.blogging_application.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
private final CategoryRepo categoryRepo;
private  final ModelMapper modelMapper;


    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       return catetogyToCategoryDTO(this.categoryRepo.save(categoryDTOToCategory(categoryDTO)));
    }

    @Override
    public CategoryDTO updateCategoty(CategoryDTO categoryDTO,Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        Category createdCategory=this.categoryRepo.save(category);
        return catetogyToCategoryDTO(createdCategory);
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {
   Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
   this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDTO getById(Integer categoryId) {
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        return catetogyToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryDTO> list=new ArrayList<>();
//        for (Category value : (this.categoryRepo.findAll())) {
//
//            list.add(catetogyToCategoryDTO(value));
//        }
        (this.categoryRepo.findAll()).forEach((value)->{
            CategoryDTO categoryDTO=catetogyToCategoryDTO(value);
            list.add(categoryDTO);
        });
return  list;
    }

    public CategoryDTO catetogyToCategoryDTO(Category category){
        return  modelMapper.map(category,CategoryDTO.class);
    }
    public Category categoryDTOToCategory(CategoryDTO categoryDTO){
        return  modelMapper.map(categoryDTO,Category.class);
    }

}
