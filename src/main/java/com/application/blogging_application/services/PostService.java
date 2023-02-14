package com.application.blogging_application.services;

import com.application.blogging_application.entities.Category;
import com.application.blogging_application.entities.User;
import com.application.blogging_application.payloads.PostDTO;

import java.util.List;

public interface PostService {
    //create
    PostDTO create(PostDTO postdto,Integer userId,Integer categoryId);
    //delete
    void delete(Integer id);
    //findAll
    List<PostDTO> getAllPost();
    //findById
    PostDTO findById(Integer id);
//    Update
    PostDTO update(PostDTO postdto,Integer id);
    //findByUser
    List<PostDTO> getPostByUser(Integer id);
    //FindByCategory
    List<PostDTO> getPostByCategory(Integer id);
}
