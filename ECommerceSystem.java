import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceSystem {
    private List<Product> products;
    private List<User> users;
    private User currentUser;
    private Cart cart;

    public ECommerceSystem() {
        products = new ArrayList<>();
        users = new ArrayList<>();
        cart = new Cart();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public boolean loginUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.checkPassword(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void logoutUser() {
        currentUser = null;
        cart.clear();
    }

    public void browseProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addToCart(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                cart.addProduct(product);
                System.out.println(product.getName() + " added to cart.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void viewCart() {
        System.out.println("Your Cart:");
        System.out.println(cart);
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }

    public void checkout() {
        if (currentUser != null) {
            System.out.println("Order placed successfully!");
            System.out.println("Order Summary:");
            System.out.println(cart);
            System.out.println("Total Price: $" + cart.getTotalPrice());
            cart.clear();
        } else {
            System.out.println("You need to login first.");
        }
    }

    public static void main(String[] args) {
        ECommerceSystem system = new ECommerceSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Adding some sample products
        system.addProduct(new Product("Laptop", 999.99, 10));
        system.addProduct(new Product("Smartphone", 599.99, 20));
        system.addProduct(new Product("Headphones", 199.99, 30));

        // Registering a sample user
        system.registerUser(new User("John Doe", "john@example.com", "password"));

        do {
            System.out.println("\nE-Commerce System Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Products");
            System.out.println("4. Add to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    system.registerUser(new User(name, email, password));
                    System.out.println("User registered successfully.");
                    break;
                case 2:
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (system.loginUser(email, password)) {
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                    break;
                case 3:
                    system.browseProducts();
                    break;
                case 4:
                    System.out.print("Enter product ID to add to cart: ");
                    String productId = scanner.nextLine();
                    system.addToCart(productId);
                    break;
                case 5:
                    system.viewCart();
                    break;
                case 6:
                    system.checkout();
                    break;
                case 7:
                    system.logoutUser();
                    System.out.println("Logged out successfully.");
                    break;
                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
