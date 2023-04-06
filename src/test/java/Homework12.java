import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Homework12 {

    @Test
    public void header() {
        Response response = RestAssured
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        String header = response.getHeader("x-secret-homework-header");
        assertEquals("Some secret value", header, "Header does not match 'Some secret value'");
    }
}
