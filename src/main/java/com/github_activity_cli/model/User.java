package com.github_activity_cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    @JsonProperty("id")
    private String id;


    @JsonProperty("name")
    private String name;

    @JsonProperty("user_view_type")
    private String userViewType;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("public_repos")
    private String publicRepos;

    @JsonProperty("bio")
    private String bio;
}
