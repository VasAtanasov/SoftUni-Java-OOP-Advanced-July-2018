package L03GEnerics.Ex07GenericAddAllMethod;

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

        List<Number> destination = new ArrayList<>();
        ListUtils.addAll(destination, integers);
        ListUtils.addAll(destination, doubles);

        System.out.println(destination);
    }
}
