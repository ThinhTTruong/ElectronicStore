public abstract class Computer extends Product {
    private double  cpuSpeed;
    private int     ram;
    private boolean ssd;
    private int     storage;

    // 6-parameter constructor
    public Computer(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage) {
        super(price, quantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
    }

    // Get methods
    public String getAttributes() {
        return " with " + cpuSpeed + "ghz CPU, " + ram + "GB RAM, " + storage + (ssd ? "GB SSD" : "GB HDD") + " drive.";
    }
}
