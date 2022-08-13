package api;

import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.google.gson.Gson;

import io.restassured.config.Config;

import java.io.*;
import java.util.Properties;
import com.typesafe.config.ConfigFactory;
import model.Pet;
import org.apache.http.HttpStatus;

import static helpers.Helper.generatePostPet;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.testng.Assert.assertEquals;

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
