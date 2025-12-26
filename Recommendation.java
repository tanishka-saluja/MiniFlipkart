import java.util.*;

public class RecommendationEngine {
    private ArrayList<Product> products;
    private ArrayList<User> users;

    public RecommendationEngine(ArrayList<Product> products, ArrayList<User> users) {
        this.products = products;
        this.users = users;
    }

    public ArrayList<Product> recommendProducts(User user) {
        ArrayList<Product> recommendations = new ArrayList<>();
        if (user.getPurchaseHistory().isEmpty()) {
            // If no history, recommend top 3 highest rated products
            products.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
            for (int i = 0; i < Math.min(3, products.size()); i++) {
                recommendations.add(products.get(i));
            }
            return recommendations;
        }

        // Find most purchased category
        HashMap<String, Integer> categoryCount = new HashMap<>();
        for (int pid : user.getPurchaseHistory()) {
            for (Product p : products) {
                if (p.getId() == pid) {
                    categoryCount.put(p.getCategory(), categoryCount.getOrDefault(p.getCategory(), 0) + 1);
                    break;
                }
            }
        }

        String favoriteCategory = Collections.max(categoryCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Recommend top 3 highest-rated products in that category
        ArrayList<Product> categoryProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equals(favoriteCategory)) {
                categoryProducts.add(p);
            }
        }
        categoryProducts.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));

        for (int i = 0; i < Math.min(3, categoryProducts.size()); i++) {
            recommendations.add(categoryProducts.get(i));
        }

        return recommendations;
    }
}
