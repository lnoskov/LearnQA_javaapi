import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Homework11 {

    @Test
    public void cookie() {
        Response response = RestAssured
                .post("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        String cookie = response.getCookie("HomeWork");
        assertEquals("hw_value", cookie, "Cookie does not match 'hm_value'");
    }
}
