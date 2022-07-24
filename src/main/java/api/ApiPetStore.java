package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ApiPetStore {

    public Response getPetByStatus(String status) {
        return given()
                .contentType(JSON)
                .param("status", status)
                .when()
                .get("getPetByStatusPath");
    }

    public Response postPet(Object pet) {
        return given()
                .contentType(JSON)
                .when()
                .body(pet)
                .post("createPetPath");
    }

    public Response deletePet(String petId) {
        return given()
                .contentType(JSON)
                .when()
                .delete(petId);
    }

    public Response deletePetString(String petId) {
        return given()
                .contentType(JSON)
                .when()
                .delete(petId);
    }

    public Response putPet(Object pet) {
        return given()
                .contentType(JSON)
                .when()
                .body(pet)
                .put();
    }


}
