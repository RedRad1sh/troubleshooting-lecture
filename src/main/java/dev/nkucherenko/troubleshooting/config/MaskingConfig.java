package dev.nkucherenko.troubleshooting.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author nkucherenko
 */
@Configuration
@ConfigurationProperties(prefix = "masking")
@Getter
@Setter
public class MaskingConfig {
    private List<MaskingObj> replaceList;
}
