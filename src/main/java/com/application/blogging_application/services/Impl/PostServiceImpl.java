package com.application.blogging_application.services.Impl;

import com.application.blogging_application.entities.Category;
import com.application.blogging_application.entities.Post;
import com.application.blogging_application.entities.User;
import com.application.blogging_application.exceptions.ResourceNotFoundException;
import com.application.blogging_application.payloads.PostDTO;
import com.application.blogging_application.repositories.CategoryRepo;
import com.application.blogging_application.repositories.PostRepo;
import com.application.blogging_application.repositories.UserRepo;
import com.application.blogging_application.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepo postRepo;
private final ModelMapper modelMapper;
private final UserRepo userRepo;
private  final CategoryRepo categoryRepo;
    public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper, UserRepo userRepo, CategoryRepo categoryRepo) {
        this.postRepo = postRepo;
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public PostDTO create(PostDTO postdto,Integer userId, Integer categoryId) {
         postdto.setPostDate(date1());
         User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","userId",userId));
         Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        Post post=postDtoToPost(postdto);
        post.setUser(user);
        post.setCategory(category);



        Post post1=this.postRepo.save(post);

        return postToPostDTO(post1);
    }

    @Override
    public void delete(Integer id) {
      Post post=this.postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","postId",id));
      this.postRepo.delete(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
       List<Post> post=this.postRepo.findAll();
       List<PostDTO> postDTOS= post.stream().map(this::postToPostDTO).toList();
       return postDTOS;
    }

    @Override
    public PostDTO findById(Integer id) {
        Post post=this.postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","postId",id));
        return postToPostDTO(post);
    }

    @Override
    public PostDTO update(PostDTO postdto, Integer id) {
        Post post=this.postRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","postId",id));
        post.setPostDescription(postdto.getPostDescription());
        post.setPostDate(date1());
        post.setPostTitle(postdto.getPostTitle());
        Post createdPost= postRepo.save(post);
        return postToPostDTO(createdPost);
    }



    @Override
    public List<PostDTO> getPostByUser(Integer id) {
        User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","userId",id));
       List<Post> post=this.postRepo.findByUser(user);
       return post.stream().map(this::postToPostDTO).toList();
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer id) {
        Category category= this.categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",id));
        List<Post> post=this.postRepo.findByCategory(category);
        return post.stream().map(this::postToPostDTO).toList();
    }

    Post postDtoToPost(PostDTO postdto){
        Post post=modelMapper.map(postdto,Post.class);
        return post;
    }
    PostDTO postToPostDTO(Post post){
        PostDTO postdto=modelMapper.map(post, PostDTO.class);
        return postdto;
    }
    public String date1() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        return formatter.format(date);

    }

}
