import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Homework7 {
    @Test
    public void Redirect(){
      String redirect = "https://playground.learnqa.ru/api/long_redirect";
        int status = 0;
        while (status != 200){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get(redirect)
                .andReturn();
        String rt = response.getHeader("Location");
        redirect = rt;
        status = response.statusCode();
        System.out.println(rt);}
        }



}
