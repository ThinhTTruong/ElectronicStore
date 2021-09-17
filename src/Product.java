public abstract class Product {
    private double  price;
    private int     stockQuantity;
    private int     soldQuantity;
    private int     cartQuantity;

    // 2-parameter constructor
    public Product(double price, int quantity) {
        this.price = price;
        this.stockQuantity = quantity;
    }

    // Get/set methods
    public abstract String getProductName();
    public abstract String getAttributes();
    public String getInfo() { return getProductName()+getAttributes(); }
    public int  getSoldQuantity() { return soldQuantity; }
    public int  getStockQuantity() { return stockQuantity; }
    public double  getPrice() { return price; }
    public int  getCartQuantity() { return cartQuantity; }

    // Add 1 item of product to cart
    public void increaseCartQuantity() {
        if (cartQuantity<stockQuantity)
            cartQuantity += 1;
    }

    // Remove 1 item of product from cart
    public void decreaseCartQuantity() {
        if (cartQuantity>0)
            cartQuantity -= 1;
    }

    // Complete selling this product in cart
    public void sellCart() {
        stockQuantity -= cartQuantity;
        soldQuantity += cartQuantity;
        cartQuantity = 0;
    }

    // Sell units and return revenue for selling
    public double sellUnits(int amount) {
        if (stockQuantity >= amount && amount > 0) {
            stockQuantity -= amount;
            soldQuantity += amount;
            return amount*price;
        }else {
            return -1.0;
        }
    }

    // String representation of the product
    public String toString() {
        return getProductName() + getAttributes() + " (" + price + " dollars each, " + stockQuantity + " in stock, " + soldQuantity + " sold)";
    }
}
