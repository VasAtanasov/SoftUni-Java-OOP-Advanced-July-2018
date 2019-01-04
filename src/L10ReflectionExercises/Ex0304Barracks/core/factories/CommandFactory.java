package L10ReflectionExercises.Ex0304Barracks.core.factories;

import L10ReflectionExercises.Ex0304Barracks.contracts.CommandInterpreter;
import L10ReflectionExercises.Ex0304Barracks.contracts.Executable;
import L10ReflectionExercises.Ex0304Barracks.core.commands.Command;
import L10ReflectionExercises.Ex0304Barracks.utilities.Constants;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;


public final class CommandFactory implements CommandInterpreter {

    private CommandFactory() {

    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, ExecutionControl.NotImplementedException {
        commandName = String.format("%s%s", commandName.toUpperCase().charAt(0), commandName.toLowerCase().substring(1));
        if (! isClass(Constants.COMMANDS_PACKAGE_NAME + commandName)) {
            throw new ExecutionControl.NotImplementedException(Constants.NO_SUCH_COMMAND);
        }
        Class<?> clazz = Class.forName(Constants.COMMANDS_PACKAGE_NAME + commandName);
        Command command = (Command) clazz.getConstructor(String[].class).newInstance((Object) data);
        return command;
    }

    private static boolean isClass(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* Factory pattern */
    public static CommandFactory getInstance() {
        final CommandFactory cf = new CommandFactory();
        return cf;
    }
}