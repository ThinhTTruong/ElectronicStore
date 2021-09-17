public class ToasterOven extends KitchenAppliance {
    private int     width;
    private boolean convection;

    // 7-parameter constructor
    public ToasterOven(double price, int quantity, int wattage, String color, String brand, int width, boolean convection) {
        super(price, quantity, wattage, color, brand);
        this.width = width;
        this.convection = convection;
    }

    // Get methods
    public String getProductName() {
        return width + " inch " + getBrand() + " Toaster " + (convection ? "with convection " : "");
    }

    // String representation of the fridge
    public String toString() {
        return super.toString();
    }
}
