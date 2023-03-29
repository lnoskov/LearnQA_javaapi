import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Homework8 {
    @Test
    public void Token() throws InterruptedException {
         String url = "https://playground.learnqa.ru/ajax/api/longtime_job";
             JsonPath response = RestAssured
                        .get(url)
                        .jsonPath();
             String token = response.get("token");
             int seconds = response.get("seconds");

             Map<String, String> params = new HashMap<>();
             params.put("token", token);
             JsonPath rs = RestAssured
                    .given()
                    .queryParams(params)
                    .get(url)
                    .jsonPath();
             String status = rs.get("status");
             System.out.println(status);
                    if (status.equals("Job is NOT ready")){
                        System.out.println("Статус соответствует Job is NOT ready");}
                    else {System.out.println("Статус не соответствует Job is NOT ready");}

                TimeUnit.SECONDS.sleep(seconds);

             JsonPath at = RestAssured
                .given()
                .queryParams(params)
                .get(url)
                .jsonPath();
             String atstatus = at.get("status");
             System.out.println(atstatus);
                    if (atstatus.equals("Job is ready")){
                        System.out.println("Статус соответствует Job is ready");}
                    else {System.out.println("Статус не соответствует Job is ready");}
             String result = at.get("result");
                    if (result == null){
                        System.out.println("Поле result пустое");
                    } else {System.out.println("Поле result = " + result);}
    }
}
