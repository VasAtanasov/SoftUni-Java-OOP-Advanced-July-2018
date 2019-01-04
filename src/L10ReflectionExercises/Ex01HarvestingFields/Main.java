package L10ReflectionExercises.Ex01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    private enum Command {
        PRIVATE, PUBLIC, PROTECTED, ALL, HARVEST,
    }

    private static Class<RichSoilLand> richSoilLandClass;
    private static List<Field> fields;
    private static List<Field> privateFields;
    private static List<Field> protectedFields;
    private static List<Field> publicFields;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        richSoilLandClass = RichSoilLand.class;
        fields = Arrays.asList(richSoilLandClass.getDeclaredFields());
        privateFields = new ArrayList<>();
        protectedFields = new ArrayList<>();
        publicFields = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        fields.forEach(filterFields);

        while (true) {
            Command command = Enum.valueOf(Command.class, reader.readLine().toUpperCase());
            if (Command.HARVEST.equals(command)) {
                break;
            }

            switch (command) {
                case PUBLIC:
                    print(publicFields);
                    break;
                case ALL:
                    print(fields);
                    break;
                case PRIVATE:
                    print(privateFields);
                    break;
                case PROTECTED:
                    print(protectedFields);
                    break;
            }
        }
    }

    private static void print(List<Field> list) {
        list.stream()
                .map(toString)
                .forEach(System.out::println);
    }

    private static Function<Field, String> toString = field -> String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());

    private static Consumer<Field> filterFields = field -> {
        int modifier = field.getModifiers();
        if (Modifier.isPrivate(modifier)) {
            privateFields.add(field);
        } else if (Modifier.isProtected(modifier)) {
            protectedFields.add(field);
        } else if (Modifier.isPublic(modifier)) {
            publicFields.add(field);
        }
    };

}
