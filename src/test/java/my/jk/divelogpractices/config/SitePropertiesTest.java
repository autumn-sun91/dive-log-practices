package my.jk.divelogpractices.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest
class SitePropertiesTest {

    @Test
    void test(@Autowired SiteProperties siteProperties) {
        assertEquals("thk.local", siteProperties.getAuthorName());
        assertEquals("dpwe231.local@gmail.com", siteProperties.getAuthorEmail());
    }
}
