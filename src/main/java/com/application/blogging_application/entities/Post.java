package com.application.blogging_application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer postId;

    private String postTitle;
    private String postDescription;
    private String postDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
}

