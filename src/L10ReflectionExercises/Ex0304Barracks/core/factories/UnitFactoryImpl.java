package L10ReflectionExercises.Ex0304Barracks.core.factories;

import L10ReflectionExercises.Ex0304Barracks.utilities.Constants;
import jdk.jshell.spi.ExecutionControl;
import L10ReflectionExercises.Ex0304Barracks.contracts.Unit;
import L10ReflectionExercises.Ex0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (! isClass(Constants.UNITS_PACKAGE_NAME + unitType)) {
            throw new ExecutionControl.NotImplementedException(Constants.NO_SUCH_UNIT);
        }
        Class<?> unit = Class.forName(Constants.UNITS_PACKAGE_NAME + unitType);
        return (Unit) unit.getConstructor().newInstance();
    }

    private static boolean isClass(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
