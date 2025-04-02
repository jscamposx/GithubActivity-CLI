package com.github_activity_cli.service;

import com.github_activity_cli.model.Event;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.Arrays;
import java.util.List;

@Service
public class GithubService {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Event> getRecentEvents(String username) {
        String url = "https://api.github.com/users/" + username + "/events";
        Event[] events = restTemplate.getForObject(url, Event[].class);
        return Arrays.asList(events != null ? events : new Event[0]);
    }
}