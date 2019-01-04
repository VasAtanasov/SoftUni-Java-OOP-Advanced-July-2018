package L04GenericsExercises.Ex08CustomListSorter;

import L04GenericsExercises.Ex07CustomList.Collection;

public class Sorter {
    private Sorter() {
    }

    public static <T extends Comparable<T>> void sort(Collection<T> collection) {
        collection.sort();
    }
}
