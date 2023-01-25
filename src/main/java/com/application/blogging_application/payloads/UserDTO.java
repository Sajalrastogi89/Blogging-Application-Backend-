package com.application.blogging_application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter@Setter
public class UserDTO {
    private int id;
   @NotBlank
   @Size(min = 4,message = "Username must be min of 4 characters")
    private String name;
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "(?=^.{8,20}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",message = "Invalid password")
    private String password;
    @NotBlank
    private String about;
}
