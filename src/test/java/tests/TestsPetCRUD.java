package tests;

import api.ApiPetStore;
import io.restassured.path.json.JsonPath;
import model.Pet;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import java.io.IOException;
import static helpers.Helper.*;
import static org.testng.Assert.assertEquals;

public class TestsPetCRUD {

    @Test
    public void testGetPet() throws IOException {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        int petId = createdPetResponse.getInt("id");
        JsonPath getPetResponse = ApiPetStore.getPet(petId).jsonPath();
//        Response createPetResponse = ApiPetStore.postPet(pet);
//        assertEquals(createPetResponse.as(Pet.class), pet);
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(getPetResponse.getInt("id"), createdPet.getId());
    }

    @Test
    public void testCreatePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
//        Response createPetResponse = ApiPetStore.postPet(createdPet);
//        Assert.assertTrue(createPetResponse.as(Pet.class).equals(createdPet));
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(createdPetResponse.getInt("id"), createdPet.getId());
    }
    @Test
    public void testUpdatePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        System.out.println(createdPetResponse);
        int petId = createdPetResponse.getInt("id");
        Pet updatedPet = generateUpdatePet(petId);
        JsonPath updatedPetResponse = ApiPetStore.putPet(updatedPet).jsonPath();
        System.out.println(updatedPetResponse);
//        Response createPetResponse = ApiPetStore.postPet(pet);
//        assertEquals(createPetResponse.as(Pet.class), pet);
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(updatedPetResponse.getInt("id"), updatedPet.getId());
    }

    @Test
    public void testDeletePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        System.out.println(createdPetResponse);
        int petId = createdPetResponse.getInt("id");
        JsonPath deletedPetResponse = ApiPetStore.deletePet(petId).jsonPath();
        System.out.println(deletedPetResponse);
//        Response createPetResponse = ApiPetStore.postPet(pet);
//        assertEquals(createPetResponse.as(Pet.class), pet);
        assertEquals(HttpStatus.SC_OK, 200);
    }
}
