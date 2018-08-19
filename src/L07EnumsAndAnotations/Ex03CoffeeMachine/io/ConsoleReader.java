package L07EnumsAndAnotations.Ex03CoffeeMachine.io;

import L07EnumsAndAnotations.Ex03CoffeeMachine.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {
    private BufferedReader reader;


    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() throws IOException {
        return reader.readLine();
    }
}
