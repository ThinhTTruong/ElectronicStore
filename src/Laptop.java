public class Laptop extends Computer {
    private double  screenSize;

    // 7-parameter constructor
    public Laptop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize) {
        super( price, quantity, cpuSpeed, ram, ssd, storage);
        this.screenSize = screenSize;
    }

    // Get methods
    public String getProductName() { return screenSize + " inch" + " Laptop PC"; }

    // String representation of the laptop
    public String toString() {
        return super.toString();
    }

}
