import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class ElectronicStore {
    private static final int MAX_PRODUCTS = 10;

    private String      name;
    private double      revenue;
    private Product[]   products;
    private int         productCount;
    private int         numSales;

    // One-parameter constructor
    public ElectronicStore(String initName) {
        this.name = initName;
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
        revenue = 0.0;
        numSales = 0;
    }

    // Get methods
    public String   getName() { return name; }
    public double   getRevenue() { return revenue; }
    public int      getProductCount() { return productCount; }
    public int      getNumberofSales() { return numSales; }

    // Set methods
    public void     setRevenue(double amount) { revenue += amount; }
    public void     setNumberofSales() { numSales +=1; }

    // Return an array of products
    public Product[] getProductList() {
        int count = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null) {
                count++;
            }
        }
        Product[] result = new Product[count];
        int curIndex = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null) {
                result[curIndex++] = products[i];
            }
        }
        return result;
    }

    // Return an array of available products
    public Product[] getAvailableList() {
        int count = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null && products[i].getCartQuantity()<products[i].getStockQuantity()) {
                count++;
            }
        }
        Product[] result = new Product[count];
        int curIndex = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null && products[i].getCartQuantity()<products[i].getStockQuantity()) {
                result[curIndex++] = products[i];
            }
        }
        return result;
    }

    // Return an array of products in cart
    public Product[] getCartList() {
        int count = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null && products[i].getCartQuantity()>0) {
                count++;
            }
        }
        Product[] result = new Product[count];
        int curIndex = 0;
        for (int i=0; i<productCount; i++) {
            if (products[i]!=null && products[i].getCartQuantity()>0) {
                result[curIndex++] = products[i];
            }
        }
        return result;
    }

    // Return an array of products in most popular order
    public Product[] getPopularList() {
        Product[] productList = getProductList();
        Arrays.sort(productList, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p2.getSoldQuantity()- p1.getSoldQuantity();
            }
        });
        return productList;
    }

    // Add an item of the product to cart given index
    public void addCart(int index) {
        getAvailableList()[index].increaseCartQuantity();
    }

    // Remove an item of the product from cart given index
    public void removeCart(int index) {
        getCartList()[index].decreaseCartQuantity();
    }

    // Return the value of products in cart
    public double getCartAmount() {
        double cartAmount = 0;
        for (int i=0; i < getCartList().length; i++) {
            cartAmount += getCartList()[i].getCartQuantity()*getCartList()[i].getPrice();
        }
        return cartAmount;
    }

    // Add a product to store's product array
    public boolean addProduct(Product p) {
        if (productCount < MAX_PRODUCTS && p != null) {
            products[productCount++] = p;
            return true;
        }
        return false;
    }

    // Zero-parameter sell product method
    public boolean sellProducts() {
        printStock();
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter product number you want to buy: ");
        int item = input.nextInt();
        System.out.println();

        System.out.print("Please enter how many units you want to buy: ");
        int amount = input.nextInt();
        System.out.println();

        return sellProducts(item, amount);
    }

    // 2-parameter sell product method
    public boolean sellProducts(int item, int amount) {
        if (item < productCount && item >= 0) {
            double sale = products[item].sellUnits(amount);
            if (sale >= 0) {
                revenue += sale;
                return true;
            }
        }
        return false;
    }

    // Print current stock of the store
    public void printStock() {
        for(int i=0; i<productCount; i++){
            System.out.println(i + ". " + products[i]);
        }
    }

    // Example model
    public static ElectronicStore createStore(){
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }
}
