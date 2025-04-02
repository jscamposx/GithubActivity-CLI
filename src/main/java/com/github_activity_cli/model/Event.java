package com.github_activity_cli.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Event {

    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("repo")
    private Repo repo;

    @JsonProperty("created_at")
    private String createdAt;

    @Data
    public static class Repo {

        @JsonProperty("name")
        private String name;

        @JsonProperty("url")
        private String url;
    }
}
