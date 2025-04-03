package com.github_activity_cli.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Repo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("html_url")
    private String url;

    @JsonProperty("description")
    private String description;
}
