package tests;

import api.ApiPetStore;
import io.restassured.path.json.JsonPath;
import model.Pet;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static helpers.Helper.*;
import static org.testng.Assert.assertEquals;

public class TestsPetCRUD {

    @Test
    public void testGetPet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        int petId = createdPetResponse.getInt("id");
        JsonPath getPetResponse = ApiPetStore.getPet(petId).jsonPath();
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(getPetResponse.getInt("id"), createdPet.getId());
        assertEquals(getPetResponse.getInt("id"), createdPet.getId());
        assertEquals(getPetResponse.getInt("category.id"), createdPet.getCategory().getId());
        assertEquals(getPetResponse.getString("category.name"), createdPet.getCategory().getName());
        assertEquals(getPetResponse.getString("name"), createdPet.getName());
        assertEquals(getPetResponse.getString("photoUrls[0]"), createdPet.getPhotoUrls().get(0));
        assertEquals(getPetResponse.getInt("tags[0].id"), createdPet.getTags().get(0).getId());
        assertEquals(getPetResponse.getString("tags[0].name"), createdPet.getTags().get(0).getName());
        assertEquals(getPetResponse.getString("status"), createdPet.getStatus().toString());
    }

    @Test
    public void testCreatePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(createdPetResponse.getInt("id"), createdPet.getId());
        assertEquals(createdPetResponse.getInt("category.id"), createdPet.getCategory().getId());
        assertEquals(createdPetResponse.getString("category.name"), createdPet.getCategory().getName());
        assertEquals(createdPetResponse.getString("name"), createdPet.getName());
        assertEquals(createdPetResponse.getString("photoUrls[0]"), createdPet.getPhotoUrls().get(0));
        assertEquals(createdPetResponse.getInt("tags[0].id"), createdPet.getTags().get(0).getId());
        assertEquals(createdPetResponse.getString("tags[0].name"), createdPet.getTags().get(0).getName());
        assertEquals(createdPetResponse.getString("status"), createdPet.getStatus().toString());
    }
    @Test
    public void testUpdatePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        int petId = createdPetResponse.getInt("id");
        Pet updatedPet = generateUpdatePet(petId);
        JsonPath updatedPetResponse = ApiPetStore.putPet(updatedPet).jsonPath();
        assertEquals(HttpStatus.SC_OK, 200);
        assertEquals(updatedPetResponse.getInt("id"), updatedPet.getId());
        assertEquals(updatedPetResponse.getInt("category.id"), updatedPet.getCategory().getId());
        assertEquals(updatedPetResponse.getString("category.name"), updatedPet.getCategory().getName());
        assertEquals(updatedPetResponse.getString("name"), updatedPet.getName());
        assertEquals(updatedPetResponse.getString("photoUrls[0]"), updatedPet.getPhotoUrls().get(0));
        assertEquals(updatedPetResponse.getInt("tags[0].id"), updatedPet.getTags().get(0).getId());
        assertEquals(updatedPetResponse.getString("tags[0].name"), updatedPet.getTags().get(0).getName());
        assertEquals(updatedPetResponse.getString("status"), updatedPet.getStatus().toString());
    }

    @Test
    public void testDeletePet() {
        Pet createdPet = generatePostPet();
        JsonPath createdPetResponse = ApiPetStore.postPet(createdPet).jsonPath();
        int petId = createdPetResponse.getInt("id");
        JsonPath deletedPetResponse = ApiPetStore.deletePet(petId).jsonPath();
        assertEquals(HttpStatus.SC_OK, 200);
    }
}
