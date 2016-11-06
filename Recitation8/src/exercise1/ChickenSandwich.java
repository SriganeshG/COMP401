package exercise1;

public class ChickenSandwich implements Sandwich {
    private String name;
    private double price;

    public ChickenSandwich(boolean spicy) {
        if (spicy) {
            name = "Spicy Chicken Sandwich";
        } else {
            name = "Regular Chicken Sandwich";
        }
        price = 2.99;
    }

    public String getSandwich() {
        return name;
    }

    public double getPrice() {
        return price * 1.075; // include tax
    }
}
