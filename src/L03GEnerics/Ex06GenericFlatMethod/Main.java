package L03GEnerics.Ex06GenericFlatMethod;

import L03GEnerics.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Double> doubles = new ArrayList<>() {{
            add(1.2);
            add(3.2);
        }};

        List<List<? extends Number>> jagged = new ArrayList<>() {{
            add(integers);
            add(doubles);
        }};

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, jagged);

        System.out.println(dest);
    }
}
