package L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.contracts;

public interface Repository<T> {

    void add(T element);

    T get(String element);

    boolean contains(String element);

    Iterable<T> getElements();

    T max();
}
