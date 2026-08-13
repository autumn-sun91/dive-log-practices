package my.jk.divelogpractices.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyServicePropertiesTest {

    @Test
    void test(@Autowired MyServiceProperties myServiceProperties) {
        assertFalse(myServiceProperties.isEnabled());
        assertEquals("thk", myServiceProperties.getSecurity().getUsername());
    }
}
