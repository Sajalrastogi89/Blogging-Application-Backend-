package com.application.blogging_application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Integer categoryId;
    @NotBlank(message = "Feild name required")
    private String categoryTitle;
    @NotBlank(message = "Feild description required")
    private String categoryDescription;
}
