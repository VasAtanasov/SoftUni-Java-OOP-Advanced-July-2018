package L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.engine;

import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.contracts.*;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.enums.Command;

import java.io.IOException;

public class GameEngine implements Engine {
    private InputReader reader;
    private Controller controller;

    public GameEngine(Controller controller, InputReader reader) {
        this.reader = reader;
        this.controller = controller;
    }

    @Override
    public void run() throws IOException {
        String input;
        while (! Command.END.name().equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            controller.dispatchCommand(tokens);
        }

//        controller.print();
    }
}
