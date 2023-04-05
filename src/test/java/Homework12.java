import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Homework12 {

    @Test
    public void header() {
        Locale.setDefault(Locale.US);
        Response response = RestAssured
                .post("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        String headers = response.getHeaders().toString();
        String datetime = ZonedDateTime.now(ZoneId.of("Africa/Abidjan"))
                .format(DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss"));
        String header = "Date=" + datetime + " GMT\n" + "Content-Type=application/json\n" + "Content-Length=15\n" + "Connection=keep-alive\n" + "Keep-Alive=timeout=10\n" + "Server=Apache\n" + "x-secret-homework-header=Some secret value\n" + "Cache-Control=max-age=0\n" + "Expires=" + datetime + " GMT";
        assertEquals(headers, header, "Headers do not match");
    }
}
