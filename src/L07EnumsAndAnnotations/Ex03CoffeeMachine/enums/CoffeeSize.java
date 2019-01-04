package L07EnumsAndAnnotations.Ex03CoffeeMachine.enums;

public enum CoffeeSize {
    //    Create enum CoffeeSize that has dosage and price – Small (50 ml, 50 c), Normal (100 ml, 75 c), Double (200 ml, 100 c)
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.dosage = dosage;
        this.price = price;
    }

    public int getDosage() {
        return this.dosage;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%c%s", this.name().charAt(0), this.name().substring(1).toLowerCase());
    }
}
