package com.github_activity_cli.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {
    public static String formatDate(String isoDate) {
        Instant instant = Instant.parse(isoDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, hh:mm a 'UTC'", new Locale("es"))
                .withZone(ZoneId.of("UTC"));
        return formatter.format(instant);
    }
}