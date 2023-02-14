package com.application.blogging_application.payloads;

import com.application.blogging_application.entities.Category;
import com.application.blogging_application.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Integer postId;

    @NotBlank(message = "Feild name required")
    private String postTitle;
    @NotBlank(message ="Feild name required")
    private String postDescription;
    private String postDate;

    private UserDTO user;

    private CategoryDTO category;
}
