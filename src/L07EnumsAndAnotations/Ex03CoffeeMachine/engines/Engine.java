package L07EnumsAndAnotations.Ex03CoffeeMachine.engines;

import L07EnumsAndAnotations.Ex03CoffeeMachine.contracts.InputReader;
import L07EnumsAndAnotations.Ex03CoffeeMachine.entities.CoffeeMachine;
import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.Coin;
import L07EnumsAndAnotations.Ex03CoffeeMachine.utilities.Constants;

import java.io.IOException;
import java.util.Arrays;

public class Engine {
    private InputReader reader;
    private CoffeeMachine coffeeMachine;

    public Engine(InputReader reader, CoffeeMachine coffeeMachine) {
        this.reader = reader;
        this.coffeeMachine = coffeeMachine;
    }

    public void run() throws IOException {
        String input;
        while (! Constants.END_COMMAND.equals(input = reader.read())) {
            String tokens[] = input.toUpperCase().split("\\s+");
            this.dispatchCommand(tokens);
        }

        coffeeMachine
                .coffeesSold()
                .forEach(System.out::println);
    }


    private void dispatchCommand(String[] tokens) {
        if (Arrays.stream(Coin.values()).anyMatch(coin -> coin.name().equals(tokens[0]))) {
            String coin = tokens[0];
            coffeeMachine.insertCoin(coin);
        } else {
            String size = tokens[0];
            String type = tokens[1];
            coffeeMachine.buyCoffee(size, type);
        }
    }
}
