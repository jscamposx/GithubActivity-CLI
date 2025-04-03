package com.github_activity_cli.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
                    "dd 'de' MMMM 'de' yyyy, hh:mm a 'UTC'", new Locale("es"))
            .withZone(ZoneId.of("UTC"));

    public static String formatDate(String isoDate) {
        Instant instant = Instant.parse(isoDate);
        return FORMATTER.format(instant);
    }
}
