package com.application.blogging_application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Entity;

import javax.persistence.ManyToOne;
import java.util.Date;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
@Entity
public class Post {
    private Integer PostId;
    private String postTitle;
    private String postDescription;
    private Date postDate;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
}
