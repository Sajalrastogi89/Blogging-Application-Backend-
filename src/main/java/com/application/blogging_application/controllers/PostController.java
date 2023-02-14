package com.application.blogging_application.controllers;

import com.application.blogging_application.payloads.APIResponse;
import com.application.blogging_application.payloads.PostDTO;
import com.application.blogging_application.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create
    @PostMapping("/user/{userId}/category/{categoryId}")
    ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO,@PathVariable Integer userId,@PathVariable Integer categoryId){
       PostDTO postDTO1= postService.create(postDTO,userId,categoryId);
       return new ResponseEntity<>(postDTO1,HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{id}")
    ResponseEntity<APIResponse> delete(@PathVariable Integer id){
        try{
        this.postService.delete(id);
        return new ResponseEntity<>(new APIResponse("Deletion done",true),HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.ok(new APIResponse("Deletion done",false));
        }

    }
    //getAll
    @GetMapping("/")
    ResponseEntity<List<PostDTO>> getAllPosts(){
        List<PostDTO> postDTOList=this.postService.getAllPost();
        return ResponseEntity.ok(postDTOList);
    }
    //getById
    @GetMapping("/{id}")
    ResponseEntity<PostDTO> getPostById(@PathVariable Integer id){
        PostDTO postDTO=this.postService.findById(id);
        return new ResponseEntity<>(postDTO,HttpStatus.OK);
    }
  //  Update
    @PutMapping("/{id}")
    ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable Integer id){
        PostDTO postDTO1=this.postService.update(postDTO,id);
        return  ResponseEntity.ok(postDTO1);
    }
   @GetMapping("/category/{id}")
    ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer id){
        List<PostDTO> postDTOList=this.postService.getPostByCategory(id);
        return  new ResponseEntity<>(postDTOList,HttpStatus.OK);
   }
    @GetMapping("/User/{id}")
    ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer id){
        List<PostDTO> postDTOList=this.postService.getPostByUser(id);
        return  new ResponseEntity<>(postDTOList,HttpStatus.OK);
    }
}
