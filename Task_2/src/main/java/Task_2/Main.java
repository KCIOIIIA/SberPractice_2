package Task_2;

import java.util.List;

import static Task_2.ConvertorUtils.mapToProductDto;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Pet cat = new Pet("Барсик", Status.AVAILABLE,
                List.of(new Photo("Барсик с цветочком",
                        "https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках",
                                "https://placekitten.com/500/605")
                ));

        Animal animalCat = mapToProductDto(cat);
        System.out.println(animalCat);
    }
}
