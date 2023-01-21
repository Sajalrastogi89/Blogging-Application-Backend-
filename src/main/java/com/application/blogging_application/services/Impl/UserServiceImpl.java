package com.application.blogging_application.services.Impl;

import com.application.blogging_application.entities.User;
import com.application.blogging_application.payloads.UserDTO;
import com.application.blogging_application.repositories.UserRepo;
import com.application.blogging_application.services.UserService;
import com.application.blogging_application.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userrepo;
    private  final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userrepo, ModelMapper modelMapper) {
        this.userrepo = userrepo;
        this.modelMapper = modelMapper;
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

    @Override
    public String date1() {

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            return formatter.format(date);

    }

    public UserDTO userToDTO(User user){
        return modelMapper.map(user,UserDTO.class);

    }
    public User dtoToUser(UserDTO userDTO){
     return modelMapper.map(userDTO,User.class);
    }


}
