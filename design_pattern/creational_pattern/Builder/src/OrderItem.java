import java.util.*;

public class OrderItem {
    private String itemName;
    private Double price;
    private Integer quantity;
    private String customization;

    public OrderItem(String itemName, double price, int quantity, String customization){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.customization = customization;
    }

    public String getItemName() { return itemName; }
    public Double getPrice() { return price; }
    public Integer getQuantity() { return quantity; }
    public String getCustomization() { return customization; }

    @Override
    public String toString() {
        return String.format("%s (x%d) - $%.2f%s",
                itemName, quantity, price,
                customization != null ? " [" + customization + "]" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrderItem orderItem = (OrderItem) obj;
        return Objects.equals(itemName, orderItem.itemName) &&
                Objects.equals(customization, orderItem.customization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, customization);
    }
}
