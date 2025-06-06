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
    private Repository repository;

    @JsonProperty("created_at")
    private String createdAt;

}
