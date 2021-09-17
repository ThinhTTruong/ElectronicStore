public abstract class KitchenAppliance extends Product {
    private int     wattage;
    private String  color;
    private String  brand;

    // 5-parameter constructor
    public KitchenAppliance(double price, int quantity, int wattage, String color, String brand) {
        super(price, quantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;
    }

    // Get methods
    public String getBrand() { return brand; }
    public String getAttributes() { return "(" + color + ", " + wattage + " watts)"; }
}
