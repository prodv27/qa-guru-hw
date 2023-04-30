package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonTests {

    private final ClassLoader cl = JsonTests.class.getClassLoader();

    @Test
    void jsonTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("Human.json"); InputStreamReader isr = new InputStreamReader(is)) {
            Human human = objectMapper.readValue(isr, Human.class);

            Assertions.assertEquals("Rack", human.firstName);
            Assertions.assertEquals("Jackson", human.lastName);
            Assertions.assertEquals("man", human.gender);
            Assertions.assertEquals(24, human.age);
            Assertions.assertEquals("126", human.address.streetAddress);
            Assertions.assertEquals("San Jose", human.address.city);
            Assertions.assertEquals("CA", human.address.state);
            Assertions.assertEquals("394221", human.address.postalCode);
            Assertions.assertEquals(List.of("computer science", "football"), human.hobbies);
        }
    }
}
