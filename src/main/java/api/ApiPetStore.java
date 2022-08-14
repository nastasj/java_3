package api;


import io.restassured.response.Response;
import java.io.*;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class ApiPetStore {


    public static String getPetStoreUrl() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(String.format("src/main/resources/env/local.properties")));
            return properties.getProperty("base.uri");
        }
        catch(java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Response getPet(int petId) {
        return given()
                .log()
                .all()
                .contentType(JSON)
                .when()
                .log()
                .all()
                .get(getPetStoreUrl() + petId);
    }

    public static Response postPet(Object pet) {
        return given()
                .log()
                .all()
                .contentType(JSON)
                .when()
                .log()
                .all()
                .body(pet)
                .post(getPetStoreUrl());
    }

    public static Response putPet(Object pet) {
        return given()
                .log()
                .all()
                .contentType(JSON)
                .when()
                .log()
                .all()
                .body(pet)
                .put(getPetStoreUrl());
    }

    public static Response deletePet(int petId) {
        return given()
                .log()
                .all()
                .contentType(JSON)
                .when()
                .log()
                .all()
                .delete(getPetStoreUrl() + petId);
    }

}
