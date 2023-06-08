package Task_2;

import java.lang.reflect.Field;
public class ConvertorUtils {
    public static Animal mapToProductDto(Pet pet) throws IllegalAccessException {
        // Для Pet
        Class clazz = pet.getClass();
        Field[] fields = clazz.getDeclaredFields();
        // Для Animal
        Animal animal = new Animal();
        Class cz = animal.getClass();
        Field[] fs = cz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Имя поля: " + field.getName() + "    тип: " + field.getType());    //получить список полей Pet
            field.setAccessible(true);              //открыть приватные поля Pet
            Object value = field.get(pet);          //получить содержимое поля в value
            if (field.getName().equals("name")){
                fs[0].setAccessible(true);              //открыть приватные поля Animal
                fs[0].set(animal, value);               //поместить в Animal title значение value
                fs[0].setAccessible(false);             //закрыть приватные поля Animal
            } else if (field.getName().equals("status")){
                if (value.equals(Status.AVAILABLE)) {
                    fs[1].setAccessible(true);              //открыть приватные поля Animal
                    fs[1].set(animal, true);               //поместить в Animal isAvailable значение true
                    fs[1].setAccessible(false);             //закрыть приватные поля Animal
                    fs[2].setAccessible(true);              //открыть приватные поля Animal
                    fs[2].set(animal, false);               //поместить в Animal isSold значение false
                    fs[2].setAccessible(false);             //закрыть приватные поля Animal
                } else {
                    fs[1].setAccessible(true);              //открыть приватные поля Animal
                    fs[1].set(animal, false);               //поместить в Animal isAvailable значение false
                    fs[1].setAccessible(false);             //закрыть приватные поля Animal
                    fs[2].setAccessible(true);              //открыть приватные поля Animal
                    fs[2].set(animal, true);               //поместить в Animal isSold значение true
                    fs[2].setAccessible(false);             //закрыть приватные поля Animal
                }
            } //else {
              //  fs[3].setAccessible(true);              //открыть приватные поля Animal
              //  fs[3].set(animal, value);               //поместить в Animal photosMap значение value
              //  fs[3].setAccessible(false);             //закрыть приватные поля Animal
           // }
            field.setAccessible(false);             //закрыть приватные поля Pet
            System.out.println("Содержимое: " + value);
        }
        return animal;
    }
}
