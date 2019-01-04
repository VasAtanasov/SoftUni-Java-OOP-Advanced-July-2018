package L10ReflectionExercises.Ex0304Barracks.core.commands;

import L10ReflectionExercises.Ex0304Barracks.annotations.Inject;
import L10ReflectionExercises.Ex0304Barracks.contracts.Executable;
import L10ReflectionExercises.Ex0304Barracks.contracts.Repository;
import L10ReflectionExercises.Ex0304Barracks.contracts.UnitFactory;


public abstract class Command  implements Executable {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

}
