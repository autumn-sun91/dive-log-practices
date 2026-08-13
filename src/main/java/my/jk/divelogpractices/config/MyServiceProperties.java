package my.jk.divelogpractices.config;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("my.service")
public class MyServiceProperties {
    private boolean enabled;
    private InetAddress remoteAddress;
    private final Security security = new Security();

    @Getter
    @Setter
    public static class Security {
        private String username;
        private String password;
        private List<String> roles;
        private Map<String, Boolean> attr;
    }
}
