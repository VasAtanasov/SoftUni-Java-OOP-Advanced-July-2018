package L07EnumsAndAnotations.Ex03CoffeeMachine;

import L07EnumsAndAnotations.Ex03CoffeeMachine.contracts.InputReader;
import L07EnumsAndAnotations.Ex03CoffeeMachine.engines.Engine;
import L07EnumsAndAnotations.Ex03CoffeeMachine.entities.CoffeeMachine;
import L07EnumsAndAnotations.Ex03CoffeeMachine.io.ConsoleReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Engine engine = new Engine(reader, coffeeMachine);

        engine.run();
    }
}
