package Task_2;
import java.lang.reflect.Field;
import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photosMap;

    public static Object mapToProductDto(Pet pet) throws IllegalAccessException {
        // Для Pet
        Class clazz = pet.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            System.out.println("Имя поля: " + field.getName() + "    тип: " + field.getType());    //получить список полей Pet
            field.setAccessible(true);              //открыть приватные поля Pet
            Object value = field.get(pet);          //получить содержимое поля в value
                                                    //поместить в title значение value
            field.setAccessible(false);             //закрыть приватные поля Pet
            System.out.println("Содержимое: " + value);
        } return null;
    }
    @Override
    public String toString(){
        return "Animal{ title = '" + title + "', isAvailable = " + isAvailable
                + ", isSold = " + isSold + ", photosMap = {" + photosMap + "}}";
    }
}
