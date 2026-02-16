package dev.nkucherenko.troubleshooting.controller;

import dev.nkucherenko.troubleshooting.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nkucherenko
 */
@RestController
@RequiredArgsConstructor
public class InfoController {
    private final InfoService infoService;

    @GetMapping("/info")
    ResponseEntity<String> getInfo() {
        return ResponseEntity.ok(infoService.getInfo());
    }

    @PutMapping("/info")
    ResponseEntity<String> editInfo(@RequestBody String info) {
        return ResponseEntity.ok(infoService.editInfo(info));
    }
}
