package L09Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {
    private static Class<Reflection> clazz;
    private static List<Field> fields;
    private static List<Method> methods;
    private static Comparator<Method> sortAlphabeticalMethods;
    private static Comparator<Field> sortAlphabeticalFields;
    private static BiPredicate<Method, String> startsWith;

    static {
        clazz = Reflection.class;
        methods = Arrays.asList(clazz.getDeclaredMethods());
        fields = Arrays.asList(clazz.getDeclaredFields());
        startsWith = (method, string) -> method.getName().startsWith(string);
        sortAlphabeticalFields = Comparator.comparing(Field::getName);
        sortAlphabeticalMethods = Comparator.comparing(Method::getName);
    }

//==========================Problem 3========================================================================================================

//    public static void main(String[] args) {
//        fields.stream()
//                .sorted(sortAlphabeticalFields)
//                .filter(field -> ! Modifier.isPrivate(field.getModifiers()))
//                .map(field -> String.format("%s must be private!", field.getName()))
//                .forEach(System.out::println);
//
//        methods.stream()
//                .filter(method -> startsWith.test(method, "get"))
//                .sorted(sortAlphabeticalMethods)
//                .filter(method -> ! Modifier.isPublic(method.getModifiers()))
//                .map(method -> String.format("%s have to be public!", method.getName()))
//                .forEach(System.out::println);
//
//        methods.stream()
//                .filter(method -> startsWith.test(method, "set"))
//                .sorted(sortAlphabeticalMethods)
//                .filter(method -> ! Modifier.isPrivate(method.getModifiers()))
//                .map(method -> String.format("%s have to be private!", method.getName()))
//                .forEach(System.out::println);
//    }

// ==========================Problem 2:========================================================================================================

//    public static void main(String[] args) {
//
//        methods.stream()
//                .filter(method -> startsWith.test(method, "get"))
//                .sorted(sortAlphabeticalMethods)
//                .map(method -> String.format("%s will return %s", method.getName(), method.getReturnType()))
//                .forEach(System.out::println);
//
//        methods.stream()
//                .filter(method -> startsWith.test(method, "set"))
//                .sorted(sortAlphabeticalMethods)
//                .map(method -> String.format("%s and will set field of %s", method.getName(), method.getParameterTypes()[0]))
//                .forEach(System.out::println);
//    }

//==========================Problem 1========================================================================================================
// Move the Main and Reflection class in "src" folder to get the points from judge.

//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//
//        System.out.println(clazz);
//        System.out.println(clazz.getSuperclass());
//
//        Class[] interfaces = clazz.getInterfaces();
//
//        for (Class anInterface : interfaces) {
//            System.out.println(anInterface);
//        }
//
//        Reflection ref = clazz.getDeclaredConstructor().newInstance();
//        System.out.println(ref);
//    }

}
