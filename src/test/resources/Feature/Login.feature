Feature: User API Testing
  Scenario: Create a new user
    Given the API base URL is "https://reqres.in/api"
    And the request body is in "src/test//resources/create.json"
    When I send a POST request to "/users"
    Then the response status code should be 201

  Scenario: Update the existing user
    Given the API base URL is "https://reqres.in/api"
    And the request body from "src/test/resources/modify.json" is set
    When I send a PUT request to "/api/users/2"
    Then the response status code should be 200

  Scenario: Delete an existing user
    Given the API base URL is "https://reqres.in/api"
    When I send a DELETE request to "/Users/636"
    Then the response status code should be 204