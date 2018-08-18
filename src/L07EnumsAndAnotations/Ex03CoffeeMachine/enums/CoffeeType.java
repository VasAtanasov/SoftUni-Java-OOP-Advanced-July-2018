package L07EnumsAndAnotations.Ex03CoffeeMachine.enums;

public enum CoffeeType {
    ESPRESSO, LATTE, IRISH;

    @Override
    public String toString() {
        return String.format("%c%s", this.name().charAt(0), this.name().substring(1).toLowerCase());
    }
}
