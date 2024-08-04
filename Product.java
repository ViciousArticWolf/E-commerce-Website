import java.util.UUID;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
    }
}
