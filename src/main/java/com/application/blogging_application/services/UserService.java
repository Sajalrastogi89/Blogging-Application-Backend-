package com.application.blogging_application.services;

import com.application.blogging_application.payloads.UserDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user,Integer id);
    UserDTO getUserById(Integer id);
    List<UserDTO> getAllUsers();
    void deleteUserById(Integer id);
}
