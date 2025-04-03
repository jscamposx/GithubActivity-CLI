package com.github_activity_cli.controller;

import com.github_activity_cli.model.Repository;
import com.github_activity_cli.model.Event;
import com.github_activity_cli.model.User;
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

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @ShellMethod(value = "Mostrar actividad reciente de un usuario de GitHub", key = "github-activity")
    public void mostrarActividad(@ShellOption(value = "--username") String username) {
        List<Event> eventos = githubService.getRecentEvents(username);

        if (eventos.isEmpty()) {
            System.out.println(YELLOW + "⚠ No hay actividad para el usuario: " + username + RESET);
            return;
        }

        System.out.println(CYAN + "\n══════════════════════════════════════════");
        System.out.println("   📢 Actividad reciente de " + username);
        System.out.println("══════════════════════════════════════════\n" + RESET);

        for (Event evento : eventos) {
            System.out.println(GREEN + "▶ Tipo de evento: " + RESET + evento.getType());
            System.out.println(BLUE + "  📌 Repositorio: " + RESET + evento.getRepository().getName());
            System.out.println("  ⏳ Fecha: " + DateFormatter.formatDate(evento.getCreatedAt()));
            System.out.println(CYAN + "----------------------------------------" + RESET);
        }
    }

    @ShellMethod(value = "Mostrar repositorios de un usuario de GitHub", key = "github-repo")
    public void mostrarRepositorios(@ShellOption(value = "--username") String username) {
        List<Repository> repositorios = githubService.getRepositories(username);

        if (repositorios.isEmpty()) {
            System.out.println(YELLOW + "⚠ No hay repositorios para el usuario: " + username + RESET);
            return;
        }

        System.out.println(CYAN + "\n══════════════════════════════════════════");
        System.out.println("   📂 Lista de repositorios de " + username);
        System.out.println("══════════════════════════════════════════\n" + RESET);

        for (Repository repositorio : repositorios) {
            System.out.println(GREEN + "🔹 Nombre: " + RESET + repositorio.getName());
            System.out.println(BLUE + "🔗 URL: " + RESET + repositorio.getUrl());

            String descripcion = (repositorio.getDescription() != null && !repositorio.getDescription().isEmpty())
                    ? repositorio.getDescription()
                    : "(Sin descripción)";

            System.out.println(YELLOW + "📝 Descripción: " + RESET + descripcion);
            System.out.println(CYAN + "----------------------------------------" + RESET);
        }
    }

    @ShellMethod(value = "Mostrar información de un usuario de GitHub", key = "github-user")
    public void mostrarInformacionUsuario(@ShellOption(value = "--username") String username) {
        User usuario = githubService.getUserDetails(username);

        if (usuario == null || usuario.getId() == null) {
            System.out.println("⚠ Error: No se encontró información para el usuario: " + username + RESET);
            return;
        }

        System.out.println(CYAN + "\n══════════════════════════════════════════");
        System.out.println("   👤 Información del usuario: " + usuario.getName());
        System.out.println("══════════════════════════════════════════\n" + RESET);

        System.out.println(GREEN + "🆔 ID: " + RESET + usuario.getId());
        System.out.println(BLUE + "🏷️ Tipo de vista: " + RESET + usuario.getUserViewType());
        System.out.println(YELLOW + "📅 Cuenta creada en: " + RESET + DateFormatter.formatDate(usuario.getCreatedAt()));
        System.out.println(GREEN + "📦 Repositorios públicos: " + RESET + usuario.getPublicRepos());

        String biografia = (usuario.getBio() != null && !usuario.getBio().isEmpty())
                ? usuario.getBio()
                : "(Sin biografía)";

        System.out.println(YELLOW + "📝 Biografía: " + RESET + biografia);
        System.out.println(CYAN + "\n══════════════════════════════════════════" + RESET);
    }
}
