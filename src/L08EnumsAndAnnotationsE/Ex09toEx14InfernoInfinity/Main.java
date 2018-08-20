package L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity;

import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.contracts.*;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.core.GameController;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.engine.GameEngine;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.entities.Weapon;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.io.ConsoleReader;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.io.ConsoleWriter;
import L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.repositories.WeaponRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Repository<Weapon> weapons = new WeaponRepository();

        Controller controller = new GameController(writer, weapons);
        Engine engine = new GameEngine(controller,reader);

        engine.run();
    }
}
