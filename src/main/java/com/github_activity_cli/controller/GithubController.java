package com.github_activity_cli.controller;

import com.github_activity_cli.service.GithubService;
import com.github_activity_cli.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class GithubController {

    private final GithubService githubService;

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @ShellMethod(value = "Obtener la actividad reciente de un usuario de GitHub", key = "github-activity")
    public void getGithubActivity(@ShellOption(value = "--username") String username) {
        List<Event> events = githubService.getRecentEvents(username);

        if (events.isEmpty()) {
            System.out.println("No se encontraron actividades para el usuario: " + username);
        } else {
            System.out.println("Actividad reciente de " + username + ":");
            for (Event event : events) {
                System.out.println("ID del evento: " + event.getId());
                System.out.println("Tipo de evento: " + event.getType());
                System.out.println("Repositorio: " + event.getRepo().getName());
                System.out.println("Creado en: " + event.getCreatedAt());
                System.out.println("-----------------------------------");
            }
        }
    }
}