package com.moroz.randomquote.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quote {

    @JsonAlias("ID")
    private Long id;
    private String title;
    private String content;
    private String link;
}
