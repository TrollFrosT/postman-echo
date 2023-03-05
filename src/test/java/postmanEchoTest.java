import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postmanEchoTest {

    @Test
    void shouldReturnPost() {

        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Some Value") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Some Value"))
        ;
    }

    @Test

    void shouldReturnPost1(){

        given()

                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("06 mart")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("06 mart") );

    }
}