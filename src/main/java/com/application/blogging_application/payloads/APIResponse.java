package com.application.blogging_application.payloads;

import com.application.blogging_application.services.UserService;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Getter@Setter

@NoArgsConstructor
public class APIResponse {
    private String message;
    private boolean Success;
    private String date=(new SimpleDateFormat("dd/MM/yy")).format(new Date());

    public APIResponse(String message, boolean Success) {
        this.message = message;
        this.Success = Success;
    }

}