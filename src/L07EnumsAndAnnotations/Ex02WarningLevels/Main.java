package L07EnumsAndAnnotations.Ex02WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String importance = reader.readLine();
        Logger logger = new Logger(importance);

        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split(": ");
            String imp = tokens[0];
            String message = tokens[1];

            logger.addMessage(new Message(imp, message));
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
