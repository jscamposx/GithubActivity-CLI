package com.github_activity_cli.service;

import com.github_activity_cli.model.Event;
import com.github_activity_cli.model.Repository;
import com.github_activity_cli.model.User;
import com.github_activity_cli.util.GithubCache;
import com.github_activity_cli.exceptions.GithubExceptionHandler;
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
        String cacheKey = "events_" + username;
        List<Event> cachedEvents = (List<Event>) GithubCache.get(cacheKey);
        if (cachedEvents != null) {
            System.out.println("--------------------------------------------------");
            System.out.println("🔄 Datos obtenidos desde el caché para el usuario: " + username);
            System.out.println("--------------------------------------------------");

            return cachedEvents;
        }

        String apiUrl = "https://api.github.com/users/" + username + "/events";
        try {
            Event[] events = restTemplate.getForObject(apiUrl, Event[].class);
            List<Event> eventList = Arrays.asList(events != null ? events : new Event[0]);
            GithubCache.put(cacheKey, eventList);
            return eventList;
        } catch (Exception e) {
            GithubExceptionHandler.handleException(e);
            return List.of();
        }
    }

    public List<Repository> getRepositories(String username) {
        String cacheKey = "repos_" + username;
        List<Repository> cachedRepositories = (List<Repository>) GithubCache.get(cacheKey);
        if (cachedRepositories != null) {
            return cachedRepositories;
        }

        String apiUrl = "https://api.github.com/users/" + username + "/repos";
        try {
            Repository[] repositories = restTemplate.getForObject(apiUrl, Repository[].class);
            List<Repository> repositoryList = Arrays.asList(repositories != null ? repositories : new Repository[0]);
            GithubCache.put(cacheKey, repositoryList);
            return repositoryList;
        } catch (Exception e) {
            GithubExceptionHandler.handleException(e);
            return List.of();
        }
    }

    public User getUserDetails(String username) {
        String cacheKey = "user_" + username;
        User cachedUser = (User) GithubCache.get(cacheKey);
        if (cachedUser != null) {
            return cachedUser;
        }

        String apiUrl = "https://api.github.com/users/" + username;
        try {
            User user = restTemplate.getForObject(apiUrl, User.class);
            GithubCache.put(cacheKey, user);
            return user;
        } catch (Exception e) {
            GithubExceptionHandler.handleException(e);
            return null;
        }
    }
}
