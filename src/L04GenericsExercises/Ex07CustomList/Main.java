package L04GenericsExercises.Ex07CustomList;

import L04GenericsExercises.Ex08CustomListSorter.Sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    private static BufferedReader reader;
    private static Collection<String> collection;
    private static Map<String, Consumer<String[]>> commands;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        collection = new CollectionImpl<>();
        commands = new LinkedHashMap<>() {{
            put("Add", tokens -> collection.add(tokens[1]));
            put("Remove", tokens -> collection.remove(Integer.parseInt(tokens[1])));
            put("Contains", tokens -> System.out.println(collection.contains(tokens[1])));
            put("Swap", tokens -> {
                int target = Integer.parseInt(tokens[1]);
                int dest = Integer.parseInt(tokens[2]);
                collection.swap(target, dest);
            });
            put("Greater", tokens -> System.out.println(collection.countGreaterThan(tokens[1])));
            put("Max", (x) -> System.out.println(collection.getMax()));
            put("Min", (x) -> System.out.println(collection.getMin()));
            put("Sort", (x) -> Sorter.sort(collection));
            put("Print", (x) -> System.out.print(collection));
        }};
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            commands.get(command).accept(tokens);
        }

    }
}
