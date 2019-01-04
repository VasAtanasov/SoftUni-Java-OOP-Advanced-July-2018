package L04GenericsExercises.Ex07CustomList;

public interface Collection<T extends Comparable<T>> {
    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int target, int dest);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    void sort();

}
