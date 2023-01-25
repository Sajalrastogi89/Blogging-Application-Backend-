package com.application.blogging_application.controllers;

import com.application.blogging_application.payloads.APIResponse;
import com.application.blogging_application.payloads.CategoryDTO;
import com.application.blogging_application.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO){
       CategoryDTO createdCategory=this.categoryService.createCategory(categoryDTO);
       return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    //Update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable Integer categoryId){
        CategoryDTO updatedCategory=this.categoryService.updateCategoty(categoryDTO,categoryId);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }
    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<APIResponse> delete(@PathVariable Integer categoryId){
        this.categoryService.deleteCategoryById(categoryId);
        return  new ResponseEntity<>(new APIResponse("Category Deleted",true),HttpStatus.OK);
    }
    //Get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId){
       CategoryDTO categoryDTO= this.categoryService.getById(categoryId);
       return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
    //GetAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> list=this.categoryService.getAllCategory();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
