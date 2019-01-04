package L04GenericsExercises.Ex03GenericSwapMethodStrings;

public class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", element.getClass().getTypeName(), element);
    }
}
