package com.application.blogging_application.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends  RuntimeException{
    private  String resourceName;
    private String feildName;
    private int feildValue;

    public ResourceNotFoundException(String resourceName, String feildName, int feildValue) {
        super(String.format("%s not found with %s:%d",resourceName,feildName,feildValue));
        this.resourceName = resourceName;
        this.feildName = feildName;
        this.feildValue = feildValue;
    }
}
