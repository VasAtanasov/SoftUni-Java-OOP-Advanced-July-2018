package L06IteratorsAndComparatorsE.Ex01ListyIterator;


public class ListyIterator<T> {
    private T[] strings;
    private int index;

    @SafeVarargs
    public ListyIterator(T... strings) {
        this.strings = strings;
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index += 1;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index + 1 < this.strings.length;
    }

    public void print() {
        System.out.println(strings[index]);
    }

}
