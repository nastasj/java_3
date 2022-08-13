package helpers;

import model.Category;
import model.Pet;
import model.Status;
import model.Tag;

import java.util.ArrayList;
import java.util.Random;

public class Helper {

    public static int generateRandomNum() {
        int randomNum = (int) (Math.random() * 25);
        return randomNum;
    }

    public static String generateRandomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = generateRandomNum();

            for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
            return randomString;
    }

    public static Pet generatePostPet() {
        int petId = generateRandomNum();
        Tag petTag = new Tag(generateRandomNum(), generateRandomString());
        Category petCategory = new Category(generateRandomNum(), generateRandomString());
        ArrayList<String> petPhotoUrls = new ArrayList<>();
        petPhotoUrls.add(generateRandomString());
        Pet generatedPet = new Pet(petId, petCategory, generateRandomString(),
                petPhotoUrls, new ArrayList<>() {{
            add(petTag);
        }}, Status.available);
        return generatedPet;
    }

        public static Pet generateUpdatePet(int petId){
            Tag petTag = new Tag(generateRandomNum(), generateRandomString());
            Category petCategory = new Category(generateRandomNum(), generateRandomString());
            ArrayList<String> petPhotoUrls = new ArrayList<>();
            petPhotoUrls.add(generateRandomString());
            Pet generatedPet = new Pet(petId, petCategory, generateRandomString(),
                    petPhotoUrls, new ArrayList<>() {{
                add(petTag);
            }}, Status.available);
            return generatedPet;
        }
}
