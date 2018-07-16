package L05IteratorsAndComparators.Ex02Library;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] books;

    @SafeVarargs
    public Library(T... books) {
        this.books = books;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<T> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return this.count < books.length;
        }

        @Override
        public T next() {
            return books[count++];
        }
    }
}
