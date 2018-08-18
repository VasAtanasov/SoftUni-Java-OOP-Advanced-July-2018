package L07EnumsAndAnotations.Ex03CoffeeMachine.entities;

import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.CoffeeSize;
import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.CoffeeType;

public class Coffee {
    private CoffeeType type;
    private CoffeeSize size;

    public Coffee(CoffeeType type, CoffeeSize size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.size, this.type);
    }
}
