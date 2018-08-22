package L10ReflectionExercises.Ex0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.getData()[1];
        this.getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
