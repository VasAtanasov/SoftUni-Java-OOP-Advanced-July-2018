package L04GenericsExercises.Ex05GenericCountMethodStrings;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", element.getClass().getTypeName(), element);
    }

    @Override
    public int compareTo(Box<T> other) {
        return element.compareTo(other.element);
    }
}
