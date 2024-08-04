import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productId) {
        products.removeIf(product -> product.getId().equals(productId));
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void clear() {
        products.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}
