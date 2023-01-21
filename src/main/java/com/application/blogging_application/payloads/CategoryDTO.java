package com.application.blogging_application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class categoryDTO {
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
