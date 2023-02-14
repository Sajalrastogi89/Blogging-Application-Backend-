package com.application.blogging_application.repositories;


import com.application.blogging_application.entities.Category;
import com.application.blogging_application.entities.Post;
import com.application.blogging_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);
}
