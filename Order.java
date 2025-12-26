import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int userId;
    private int productId;
    private LocalDateTime orderTime;

    public Order(int orderId, int userId, int productId) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.orderTime = LocalDateTime.now();
    }

    public int getOrderId() { return orderId; }
    public int getUserId() { return userId; }
    public int getProductId() { return productId; }
    public LocalDateTime getOrderTime() { return orderTime; }

    @Override
    public String toString() {
        return "OrderID: " + orderId + " | UserID: " + userId + " | ProductID: " + productId + " | Time: " + orderTime;
    }
}
