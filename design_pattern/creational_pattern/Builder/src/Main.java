import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT ORDER SYSTEM TEST ===\n");

        // Test 1: Simple dine-in order
        try {
            System.out.println("Test 1: Simple Dine-in Order");
            RestaurantOrder order1 = RestaurantOrder.builder()
                    .orderId("ORD-001")
                    .customerName("John Doe")
                    .orderType(OrderType.DINE_IN)
                    .addItem(new OrderItem("Burger", 12.99, 1, "No onions"))
                    .addItem(new OrderItem("Fries", 4.99, 1, null))
                    .paymentMethod(PaymentMethod.CARD)
                    .taxRate(8.5)
                    .build();

            System.out.println(order1);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test 2: Complex delivery order
        try {
            System.out.println("Test 2: Complex Delivery Order");
            RestaurantOrder order2 = RestaurantOrder.builder()
                    .orderId("ORD-002")
                    .customerName("Jane Smith")
                    .orderType(OrderType.DELIVERY)
                    .addItem(new OrderItem("Pizza", 18.99, 2, "Extra cheese"))
                    .addItem(new OrderItem("Salad", 8.99, 1, "Dressing on side"))
                    .specialInstructions("Ring doorbell twice")
                    .addDietaryRestriction("vegetarian")
                    .addDietaryRestriction("gluten-free")
                    .spiceLevel(SpiceLevel.MEDIUM)
                    .priorityLevel(PriorityLevel.HIGH)
                    .deliveryAddress("123 Main St, City, State 12345")
                    .contactPhone("555-0123")
                    .deliveryTime(LocalDateTime.now().plusHours(1))
                    .deliveryFee(3.99)
                    .paymentMethod(PaymentMethod.DIGITAL_WALLET)
                    .discountPercentage(10.0)
                    .taxRate(8.5)
                    .tipAmount(5.00)
                    .build();

            System.out.println(order2);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test 3: Takeout order with spice preference
        try {
            System.out.println("Test 3: Takeout Order");
            RestaurantOrder order3 = RestaurantOrder.builder()
                    .orderId("ORD-003")
                    .customerName("Mike Johnson")
                    .orderType(OrderType.TAKEOUT)
                    .addItem(new OrderItem("Spicy Chicken Wings", 15.99, 1, "Extra spicy"))
                    .addItem(new OrderItem("Garlic Bread", 6.99, 1, null))
                    .spiceLevel(SpiceLevel.EXTRA_HOT)
                    .addDietaryRestriction("dairy-free")
                    .paymentMethod(PaymentMethod.CASH)
                    .discountPercentage(5.0)
                    .taxRate(7.25)
                    .build();

            System.out.println(order3);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test 4: Error handling - missing required fields
        try {
            System.out.println("Test 4: Error Handling - Missing Customer Name");
            RestaurantOrder.builder()
                    .orderId("ORD-004")
                    // Missing customer name
                    .orderType(OrderType.DINE_IN)
                    .addItem(new OrderItem("Coffee", 2.99, 1, null))
                    .build();
        } catch (Exception e) {
            System.err.println("Expected Error: " + e.getMessage() + "\n");
        }

        // Test 5: Error handling - delivery without address
        try {
            System.out.println("Test 5: Error Handling - Delivery Without Address");
            RestaurantOrder.builder()
                    .orderId("ORD-005")
                    .customerName("Test Customer")
                    .orderType(OrderType.DELIVERY)
                    .addItem(new OrderItem("Pizza", 18.99, 1, null))
                    // Missing delivery address
                    .build();
        } catch (Exception e) {
            System.err.println("Expected Error: " + e.getMessage() + "\n");
        }

        // Test 6: Copy functionality
        try {
            System.out.println("Test 6: Copy Functionality");
            RestaurantOrder original = RestaurantOrder.builder()
                    .orderId("ORD-006")
                    .customerName("Original Customer")
                    .orderType(OrderType.TAKEOUT)
                    .addItem(new OrderItem("Sandwich", 9.99, 1, null))
                    .paymentMethod(PaymentMethod.CARD)
                    .build();

            RestaurantOrder modified = original.copy()
                    .orderId("ORD-006-COPY")
                    .customerName("Modified Customer")
                    .addItem(new OrderItem("Drink", 2.99, 1, null))
                    .build();

            System.out.println("Original Order Total: $" + String.format("%.2f", original.calculateTotal()));
            System.out.println("Modified Order Total: $" + String.format("%.2f", modified.calculateTotal()));
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test 7: Duplicate item prevention
        try {
            System.out.println("Test 7: Duplicate Item Prevention");
            RestaurantOrder.builder()
                    .orderId("ORD-007")
                    .customerName("Test Customer")
                    .orderType(OrderType.DINE_IN)
                    .addItem(new OrderItem("Burger", 12.99, 1, "No onions"))
                    .addItem(new OrderItem("Burger", 12.99, 1, "No onions")) // Duplicate
                    .build();
        } catch (Exception e) {
            System.err.println("Expected Error: " + e.getMessage() + "\n");
        }

        System.out.println("=== ALL TESTS COMPLETED ===");
    }
}
