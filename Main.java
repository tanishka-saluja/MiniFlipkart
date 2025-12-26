import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        RecommendationEngine engine = new RecommendationEngine(products, users);
        int orderCounter = 1;

        while (true) {
            System.out.println("\n=== Mini Flipkart ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Make Purchase");
            System.out.println("6. Recommend Products");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Rating (0-5): ");
                    double rating = sc.nextDouble();
                    products.add(new Product(pid, pname, category, price, rating));
                    System.out.println("Product added!");
                    break;

                case 2:
                    System.out.println("\n--- Products ---");
                    for (Product p : products) System.out.println(p);
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String uname = sc.nextLine();
                    users.add(new User(uid, uname));
                    System.out.println("User added!");
                    break;

                case 4:
                    System.out.println("\n--- Users ---");
                    for (User u : users) System.out.println(u);
                    break;

                case 5:
                    System.out.print("User ID: ");
                    int buyUid = sc.nextInt();
                    System.out.print("Product ID: ");
                    int buyPid = sc.nextInt();

                    User buyUser = null;
                    Product buyProduct = null;
                    for (User u : users) if (u.getId() == buyUid) buyUser = u;
                    for (Product p : products) if (p.getId() == buyPid) buyProduct = p;

                    if (buyUser != null && buyProduct != null) {
                        buyUser.addPurchase(buyPid);
                        orders.add(new Order(orderCounter++, buyUid, buyPid));
                        System.out.println("Purchase successful!");
                    } else {
                        System.out.println("Invalid user or product ID!");
                    }
                    break;

                case 6:
                    System.out.print("User ID for recommendations: ");
                    int recUid = sc.nextInt();
                    User recUser = null;
                    for (User u : users) if (u.getId() == recUid) recUser = u;

                    if (recUser != null) {
                        ArrayList<Product> recs = engine.recommendProducts(recUser);
                        System.out.println("\n--- Recommended Products ---");
                        for (Product p : recs) System.out.println(p);
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
