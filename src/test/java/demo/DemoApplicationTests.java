package demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"
})
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Just checking if the Spring context loads without error
    }

}
