package L03GEnerics.Ex02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
    }
}
