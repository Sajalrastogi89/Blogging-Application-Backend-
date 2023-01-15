package com.application.blogging_application.services.Impl;

import com.application.blogging_application.entities.User;
import com.application.blogging_application.payloads.UserDTO;
import com.application.blogging_application.repositories.UserRepo;
import com.application.blogging_application.services.UserService;
import com.application.blogging_application.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userrepo;

    public UserServiceImpl(UserRepo userrepo) {
        this.userrepo = userrepo;
    }


    @Override
    public UserDTO createUser(UserDTO user) {
        User createdUser=this.userrepo.save(dtoToUser(user));
        return userToDTO(createdUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        User user1=this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        user1.setAbout(userDTO.getAbout());
        user1.setName(userDTO.getName());
        user1.setPassword(userDTO.getPassword());
        user1.setEmail(userDTO.getEmail());
        User user=userrepo.save(user1);
        UserDTO userDTO1=userToDTO(user);
        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user=this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        return userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> user=this.userrepo.findAll();
      List<UserDTO> userDTO=user.stream().map(user1->userToDTO(user1)).collect(Collectors.toList());
        return userDTO;
    }

    @Override
    public void deleteUserById(Integer id) {
      User user=this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
      this.userrepo.delete(user);
    }

    public UserDTO userToDTO(User user){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAbout(user.getAbout());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return  userDTO;
    }
    public User dtoToUser(UserDTO userDTO){
        User user=new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setAbout((userDTO.getAbout()));
        return user;
    }


}
