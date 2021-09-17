public class Desktop extends  Computer {
    private String  profile;

    // 7-parameter constructor
    public Desktop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile) {
        super( price, quantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }

    // Get methods
    public String getProductName() { return profile + " Desktop PC"; }

    // String representation of the desktop
    public String toString() {
        return super.toString();
    }
}
