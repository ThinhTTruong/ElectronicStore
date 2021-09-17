public class Fridge extends KitchenAppliance {
    private double  cubicFeet;
    private boolean hasFreezer;

    // 7-parameter constructor
    public Fridge(double price, int quantity, int wattage, String color, String brand, double cubicFeet, boolean freezer) {
        super(price, quantity, wattage, color, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = freezer;
    }

    // Get methods
    public String getProductName() {
        return cubicFeet + " cu. ft. " + getBrand() + " Fridge " + (hasFreezer ? "with Freezer " : "");
    }

    // String representation of the fridge
    public String toString() {
        return super.toString();
    }
}
