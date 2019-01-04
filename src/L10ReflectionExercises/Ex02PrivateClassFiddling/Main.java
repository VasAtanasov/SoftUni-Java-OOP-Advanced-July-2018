package L10ReflectionExercises.Ex02PrivateClassFiddling;

import L10ReflectionExercises.Ex02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;


public class Main {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("_");
            int number = Integer.parseInt(tokens[1]);

            Method declaredMethod = blackBoxInt.getClass().getDeclaredMethod(tokens[0], int.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(blackBoxInt, number);

            Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
            innerValue.setAccessible(true);

            System.out.println(innerValue.get(blackBoxInt));
        }
    }

}
