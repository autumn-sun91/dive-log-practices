package my.jk.divelogpractices.web;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestController {
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "OK");
    }
}
