package cl.jesu.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@EnableConfigurationProperties
public class ApplicationProperties {

}
