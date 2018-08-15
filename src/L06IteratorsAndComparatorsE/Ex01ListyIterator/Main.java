package L06IteratorsAndComparatorsE.Ex01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader reader;
    private static final String CREATE = "Create";
    private static final String HAS_NEXT = "HasNext";
    private static final String MOVE = "Move";
    private static final String PRINT = "Print";
    private static final String END_COMMAND = "END";
    private static ListyIterator listyIterator;

    static {

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            String[] strings = input.split("\\s+");
            String command = strings[0];
            switch (command) {
                case CREATE:
                    //noinspection unchecked
                    listyIterator = new ListyIterator(Arrays.stream(strings).skip(1).toArray());
                    break;
                case HAS_NEXT:
                    System.out.println(listyIterator.hasNext());
                    break;
                case MOVE:
                    System.out.println(listyIterator.move());
                    break;
                case PRINT:
                    try {
                        listyIterator.print();
                    } catch (Exception ex) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
            }
        }

    }
}
