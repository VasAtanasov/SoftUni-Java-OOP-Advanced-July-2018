package L03GEnerics.Ex05NullFinder;

import L03GEnerics.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 2, null);
        List<Integer> intNulls = ListUtils.getNullIndices(integers);
        System.out.println(intNulls);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", null, "b");
        List<Integer> stringNulls = ListUtils.getNullIndices(strings);
        System.out.println(stringNulls);
    }
}
