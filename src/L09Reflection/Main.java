package L09Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {
    private static Class<Reflection> clazz;
    private static List<Field> fields;
    private static List<Method> methods;
    private static List<Method> getters;
    private static List<Method> setters;

    static {
        clazz = Reflection.class;
    }

//==========================Problem 3========================================================================================================
//    public static void main(String[] args) {
//        methods = Arrays.asList(clazz.getDeclaredMethods());
//
//        fields = Arrays.stream(clazz.getDeclaredFields())
//                .sorted(sortAlphabeticalFields)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        getters = getFilterSortMethods(methods, "get");
//
//        setters = getFilterSortMethods(methods, "set");
//
//        fields.stream()
//                .filter(field -> ! Modifier.isPrivate(field.getModifiers()))
//                .map(field -> String.format("%s must be private!", field.getName()))
//                .forEach(System.out::println);
//
//        getters.stream()
//                .filter(method -> ! Modifier.isPublic(method.getModifiers()))
//                .map(method -> String.format("%s have to be public!", method.getName()))
//                .forEach(System.out::println);
//
//        setters.stream()
//                .filter(method -> ! Modifier.isPrivate(method.getModifiers()))
//                .map(method -> String.format("%s have to be private!", method.getName()))
//                .forEach(System.out::println);
//    }

//==========================Problem 2:========================================================================================================
//    public static void main(String[] args) {
//
//        methods = Arrays.asList(clazz.getDeclaredMethods());
//        getFilterSortMethods(methods, "get").
//                stream()
//                .map(method -> String.format("%s will return %s", method.getName(), method.getReturnType()))
//                .forEach(System.out::println);
//
//        getFilterSortMethods(methods, "set")
//                .stream()
//                .map(method -> String.format("%s and will set field of %s", method.getName(), method.getParameterTypes()[0]))
//                .forEach(System.out::println);
//    }

//==========================Problem 1========================================================================================================
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//
//        System.out.println(clazz.getSimpleName());
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

    private static List<Method> getFilterSortMethods(List<Method> methods, String stringBegging) {
        return methods
                .stream()
                .filter(method -> startsWith.test(method, stringBegging))
                .sorted(sortAlphabeticalMethods)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Comparator<Method> sortAlphabeticalMethods = Comparator.comparing(Method::getName);

    private static Comparator<Field> sortAlphabeticalFields = Comparator.comparing(Field::getName);

    private static BiPredicate<Method, String> startsWith = (m, s) -> m.getName().startsWith(s);
}
