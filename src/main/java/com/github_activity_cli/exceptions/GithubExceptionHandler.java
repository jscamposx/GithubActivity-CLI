package com.github_activity_cli.exceptions;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

public class GithubExceptionHandler {

    public static void handleException(Exception e) {
        if (e instanceof HttpClientErrorException.NotFound) {
            System.out.println("⚠ Error: Usuario no encontrado.");
        } else if (e instanceof HttpClientErrorException.Forbidden) {
            System.out.println("⚠ Error: Has alcanzado el límite de peticiones de la API de GitHub. Inténtalo más tarde.");
        } else if (e instanceof HttpServerErrorException) {
            System.out.println("⚠ Error: Problema en el servidor de GitHub. Inténtalo más tarde.");
        } else if (e instanceof ResourceAccessException) {
            System.out.println("⚠ Error: No se pudo conectar a GitHub. Revisa tu conexión a Internet.");
        } else {
            System.out.println("⚠ Error inesperado: " + e.getMessage());
        }
    }
}