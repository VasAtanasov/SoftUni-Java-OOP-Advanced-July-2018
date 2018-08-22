package L10ReflectionExercises.Ex0304Barracks;

import L10ReflectionExercises.Ex0304Barracks.contracts.CommandInterpreter;
import L10ReflectionExercises.Ex0304Barracks.contracts.Repository;
import L10ReflectionExercises.Ex0304Barracks.contracts.Runnable;
import L10ReflectionExercises.Ex0304Barracks.contracts.UnitFactory;
import L10ReflectionExercises.Ex0304Barracks.core.Engine;
import L10ReflectionExercises.Ex0304Barracks.core.factories.CommandFactory;
import L10ReflectionExercises.Ex0304Barracks.core.factories.UnitFactoryImpl;
import L10ReflectionExercises.Ex0304Barracks.data.UnitRepository;


public class Main {

    public static void main(String[] args)  {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = CommandFactory.getInstance();
        Runnable engine = new Engine(commandInterpreter, repository, unitFactory);
        engine.run();
    }
}
