package dev.nkucherenko.troubleshooting.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nkucherenko
 */
@Getter
@Setter
public class MaskingObj {
    String regex;
    String replace;
}
