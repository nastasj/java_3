package tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestsPetCRUD {

    @Test
    public void testCreatePet(){
        int petId = faker.number().numberBetween(0,999);
        createPetWithId(petId);
        JsonPath response = getPetFromTheStoreById(petId, 200);
        assertEquals(response.getInt("id"), petId);
    }

}
