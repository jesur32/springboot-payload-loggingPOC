package cl.jesu.api.healthchecker;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ServerTimeHealthIndicator implements HealthIndicator {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public Health health() {
        String date = LocalDateTime.now().format(formatter);
        return Health.up()
            .withDetail("server_time", date)
            .build();
    }
}
