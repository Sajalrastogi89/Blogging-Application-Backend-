package com.application.blogging_application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Post {
    @Id
    private Integer PostId;
    @NotBlank(message = "postDate shout not be empty after trimming or null")
    private String postTitle;
    @NotBlank(message = "postDate shout not be empty after trimming or null")
    private String postDescription;
    @NotBlank(message = "postDate shout not be empty after trimming or null")
    private Date postDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
}

