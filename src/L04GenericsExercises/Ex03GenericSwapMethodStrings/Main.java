package L04GenericsExercises.Ex03GenericSwapMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Box<String>> boxes = new ArrayList<>();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(reader.readLine());
            boxes.add(box);
        }

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        swap(boxes, indexes);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<T> list, int[] indexes) {
        T temp = list.get(indexes[0]);
        list.set(indexes[0], list.get(indexes[1]));
        list.set(indexes[1], temp);
    }
}
