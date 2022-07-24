package helpers;

import model.Category;
import model.Pet;
import model.Tag;

import java.util.ArrayList;
import java.util.Random;

public class Helper {

    public static int generateRandomNum() {
        int randomNum = (int) (Math.random() * 10000);
        return randomNum;
    }

    public static String generateRandomString() {
        Random random = new Random();
        String randomString = random.ints(97, 122 + 1)
                .limit(15)
                .toString();
        return randomString;
    }

    public static Pet generatePet(int id){
        Tag tag = new Tag(generateRandomNum(), generateRandomString());
        Category category = new Category(generateRandomNum(), generateRandomString());
        Pet generatedPet = new Pet(generateRandomNum(), category, generateRandomString(),
                new ArrayList<>(), new ArrayList<Tag>() {{
            add(tag);
        }}, "avaliable");
        return generatedPet;
    }
}
