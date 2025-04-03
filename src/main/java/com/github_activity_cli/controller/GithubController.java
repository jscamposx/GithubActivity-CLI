package com.github_activity_cli.controller;

import com.github_activity_cli.model.Repo;
import com.github_activity_cli.model.Event;
import com.github_activity_cli.service.GithubService;
import com.github_activity_cli.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class GithubController {

    private final GithubService githubService;

    // Colores ANSI para mejorar la presentación en consola
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @ShellMethod(value = "Obtener la actividad reciente de un usuario de GitHub", key = "github-activity")
    public void obtenerActividadGitHub(@ShellOption(value = "--username") String usuario) {
        List<Event> eventos = githubService.getRecentEvents(usuario);

        if (eventos.isEmpty()) {
            System.out.println(YELLOW + "⚠ No se encontraron actividades para el usuario: " + usuario + RESET);
        } else {
            System.out.println(CYAN + "\n══════════════════════════════════════════");
            System.out.println("   📢 Actividad reciente de " + usuario);
            System.out.println("══════════════════════════════════════════\n" + RESET);

            for (Event evento : eventos) {
                System.out.println(GREEN + "▶ Tipo de evento: " + RESET + evento.getType());
                System.out.println(BLUE + "  📌 Repositorio: " + RESET + evento.getRepo().getName());
                System.out.println("  ⏳ Fecha: " + DateFormatter.formatDate(evento.getCreatedAt()));
                System.out.println(CYAN + "----------------------------------------" + RESET);
            }
        }
    }

    @ShellMethod(value = "Obtener los repositorios de un usuario de GitHub", key = "github-repo")
    public void obtenerRepositoriosGitHub(@ShellOption(value = "--username") String usuario) {
        List<Repo> repositorios = githubService.getRepositorys(usuario);

        if (repositorios.isEmpty()) {
            System.out.println(YELLOW + "⚠ No hay repositorios para el usuario: " + usuario + RESET);
        } else {
            System.out.println(CYAN + "\n══════════════════════════════════════════");
            System.out.println("   📂 Lista de repositorios de " + usuario);
            System.out.println("══════════════════════════════════════════\n" + RESET);

            for (Repo repo : repositorios) {
                System.out.println(GREEN + "🔹 Nombre: " + RESET + repo.getName());
                System.out.println(BLUE + "🔗 URL: " + RESET + repo.getUrl());


                if (repo.getDescription() != null && !repo.getDescription().isEmpty()) {
                    System.out.println(YELLOW + "📝 Descripción: " + RESET + repo.getDescription());
                } else {
                    System.out.println(YELLOW + "📝 Descripción: " + RESET + "(Sin descripción)");
                }

                System.out.println(CYAN + "----------------------------------------" + RESET);
            }
        }
    }
}
