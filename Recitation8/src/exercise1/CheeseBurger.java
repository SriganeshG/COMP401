package exercise1;

public class CheeseBurger implements Sandwich {
    private String name;
    private double price;

    public CheeseBurger(int nPatty) {
        switch (nPatty) {
            case 1:
                name = "Single Cheeseburger";
                price = 3.49;
            case 2:
                name = "Double Cheeseburger";
                price = 4.49;
            case 3:
                name = "Triple Cheeseburger";
                price = 5.49;
            default:
                System.out.println("error making burger");

        }
    }

    public String getSandwich() {
        return name;
    }

    public double getPrice() {
        return price * 1.075; // include tax
    }
}
