package L07EnumsAndAnotations.Ex03CoffeeMachine.entities;

import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.CoffeeSize;
import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.CoffeeType;
import L07EnumsAndAnotations.Ex03CoffeeMachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine  {
    private int totalCoinValue;
    private List<Coffee> coffeesSold;

    public CoffeeMachine() {
        this.totalCoinValue = 0;
        this.coffeesSold = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = Enum.valueOf(CoffeeSize.class, size);
        if (coffeeSize.getPrice() <= this.totalCoinValue) {
            CoffeeType coffeeType = Enum.valueOf(CoffeeType.class, type);
            Coffee coffee = new Coffee(coffeeType, coffeeSize);
            this.coffeesSold.add(coffee);
            this.totalCoinValue = 0;
        }
    }

    public void insertCoin(String coin) {
        this.totalCoinValue += Enum.valueOf(Coin.class, coin).getValue();
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeesSold;
    }
}
