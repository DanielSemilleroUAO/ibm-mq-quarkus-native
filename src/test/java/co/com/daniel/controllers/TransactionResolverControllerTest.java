package co.com.daniel.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.junit.QuarkusTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
@QuarkusTest
public class TransactionResolverControllerTest {


    @Test
    void testConfirmErrorBadRequestTransaction() throws JsonProcessingException {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("transactionId", "12345");
        requestBody.put("amount", 100.0);
        requestBody.put("currency", "USD");

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/spi/v1/enterprise/transaction/wait")
                .then()
                .statusCode(200);

    }



}
