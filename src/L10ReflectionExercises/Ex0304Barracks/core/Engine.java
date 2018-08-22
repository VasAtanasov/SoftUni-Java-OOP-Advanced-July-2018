package L10ReflectionExercises.Ex0304Barracks.core;

import L10ReflectionExercises.Ex0304Barracks.annotations.Inject;
import L10ReflectionExercises.Ex0304Barracks.contracts.*;
import L10ReflectionExercises.Ex0304Barracks.contracts.Runnable;
import L10ReflectionExercises.Ex0304Barracks.core.commands.Command;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private CommandInterpreter commandInterpreter;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Engine(CommandInterpreter commandInterpreter, Repository repository, UnitFactory unitFactory) {
        this.commandInterpreter = commandInterpreter;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                Executable command = commandInterpreter.interpretCommand(data, commandName);
                this.injectDependency(command);
                String output = command.execute();
                if (output.equals("fight")) {
                    break;
                }
                System.out.println(output);
            } catch (RuntimeException | IOException | ExecutionControl.NotImplementedException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void injectDependency(Executable command) throws IllegalAccessException {
        Field[] engineFields = Arrays.stream(Engine.class.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .peek(field -> field.setAccessible(true))
                .toArray(Field[]::new);

        Field[] commandFields = Arrays.stream(Command.class.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Inject.class))
                .peek(field -> field.setAccessible(true))
                .toArray(Field[]::new);

        for (Field commandField : commandFields) {
            for (Field engineField : engineFields) {
                if (commandField.getType().equals(engineField.getType()) && commandField.getName().equals(engineField.getName())) {
                    commandField.setAccessible(true);
                    commandField.set(command, engineField.get(this));
                }
            }
        }
    }
}
