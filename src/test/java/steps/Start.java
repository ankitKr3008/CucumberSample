package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Start{
    private Response response;
    private String baseUrl;
    private File requestBodyFile;

    @Given("the API base URL is {string}")
    public void the_api_base_url_is(String url) {
        RestAssured.baseURI = url;
    }

    @Given("the request body is in {string}")
    public void the_request_body_is_in(String filePathCreate) {
        requestBodyFile = new File(filePathCreate);
    }

    @Given("the request body from {string} is set")
    public void the_request_body_from_is_set(String filePathUpdate) {
        requestBodyFile = new File(filePathUpdate);

    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBodyFile)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
        System.out.println("Response status is "+response.getStatusCode());
    }

    @When("I send a PUT request to {string}")
    public void i_send_a_put_request_to(String endpoint) {
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBodyFile)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
        System.out.println("Response status is "+response.getStatusCode());
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
        System.out.println("Response status is "+response.getStatusCode());
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
