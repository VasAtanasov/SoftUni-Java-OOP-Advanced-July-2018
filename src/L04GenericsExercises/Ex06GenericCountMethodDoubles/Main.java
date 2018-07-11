package L04GenericsExercises.Ex06GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Box<Double>> boxes = new ArrayList<>();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box<Double> box = new Box<>(Double.parseDouble(reader.readLine()));
            boxes.add(box);
        }

        Box<Double> element = new Box<>(Double.parseDouble(reader.readLine()));
        int count = count(boxes, element);
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int count(List<T> list, T element) {
        int count = 0;
        for (T item : list) {
            if (element.compareTo(item) < 0) {
                count++;
            }
        }
        return count;
    }
}
