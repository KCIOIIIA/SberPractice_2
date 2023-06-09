package Task_2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertorUtils {
    public static Animal mapToProductDto(Pet pet) throws IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        // Для Pet
        Class clazz = pet.getClass();
        Field[] fields = clazz.getDeclaredFields();
        // Для Animal
        Animal animal = new Animal();
        Class cz = animal.getClass();
        Field[] fs = cz.getDeclaredFields();
        for(Field field : fields) {
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
            } else {
                Map <String, String> animal0 = new HashMap();
                List pet0 = (List) field.get(pet);
                String val = null, key = null;
                for(Object object: pet0){
                    Class clazz0 = object.getClass();
                    Field [] fields0 = clazz0.getDeclaredFields();
                    for(Field field0 : fields0) {
                        if (field0.getName().equals("name")){
                            field0.setAccessible(true);
                            String v = (String) field0.get(object);
                            field0.setAccessible(false);
                            val = v;
                        } else {
                            field0.setAccessible(true);
                            String k = (String) field0.get(object);
                            field0.setAccessible(false);
                            key = k;
                            animal0.put(val, key);
                        }
                    }
                }
                fs[3].setAccessible(true);
                fs[3].set(animal, animal0);
                fs[3].setAccessible(false);
            }
            field.setAccessible(false);             //закрыть приватные поля Pet
        }
        return animal;
    }
}
