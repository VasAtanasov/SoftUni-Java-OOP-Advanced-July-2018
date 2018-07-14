package L05IteratorsAndComparators.Ex02Library;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] ts;

    public Library(T... ts) {
        this.ts = ts;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<T> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return this.count < ts.length;
        }

        @Override
        public T next() {
            return ts[count++];
        }
    }
}
