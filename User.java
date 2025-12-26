import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Integer> purchaseHistory;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.purchaseHistory = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public ArrayList<Integer> getPurchaseHistory() { return purchaseHistory; }

    public void addPurchase(int productId) {
        purchaseHistory.add(productId);
    }

    @Override
    public String toString() {
        return id + ": " + name + " | Purchases: " + purchaseHistory.size();
    }
}
