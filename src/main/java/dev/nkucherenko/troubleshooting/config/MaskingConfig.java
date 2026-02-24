package dev.nkucherenko.troubleshooting.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class MaskingConfig {
    private List<MaskingObj> replaceList;
}
