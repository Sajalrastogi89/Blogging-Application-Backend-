package com.application.blogging_application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter@Setter
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}
