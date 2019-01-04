package L04GenericsExercises.Ex07CustomList;

import java.util.*;

public class CollectionImpl<T extends Comparable<T>> implements Collection<T>, Iterable<T> {
    private List<T> elements;

    public CollectionImpl() {
        this.elements = new ArrayList<>();
    }

    private boolean isInRange(int index) {
        return index >= 0 && index < this.elements.size();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        if (isInRange(index)) {
            return this.elements.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    @Override
    public void swap(int target, int dest) {
        if (isInRange(target) && isInRange(dest)) {
            T temp = this.elements.get(target);
            this.elements.set(target, this.elements.get(dest));
            this.elements.set(dest, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T elementFromCollection : elements) {
            if (elementFromCollection.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        return Collections.max(this.elements);
    }

    @Override
    public T getMin() {
        return Collections.min(this.elements);
    }

    @Override
    public void sort() {
        this.elements.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.elements.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
