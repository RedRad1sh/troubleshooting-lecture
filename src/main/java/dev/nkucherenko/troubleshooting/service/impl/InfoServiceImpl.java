package dev.nkucherenko.troubleshooting.service.impl;

import dev.nkucherenko.troubleshooting.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author nkucherenko
 */
@Service
@Slf4j
public class InfoServiceImpl implements InfoService {
    private String info = "Basic info";

    @Override
    public String getInfo() {
        log.trace(">> getInfo >>");
        return info;
    }

    @Override
    public String editInfo(String info) {
        log.trace(">> editInfo");
        this.info = info;
        log.info("Информация была отредактирована");
        log.trace("<< editInfo");
        return info;
    }
}
