import java.time.LocalDateTime;
import java.util.*;

class RestaurantOrder {
    // Required fields
    private final String orderId;
    private final String customerName;
    private final OrderType orderType;

    // Optional fields
    private final List<OrderItem> items;
    private final String specialInstructions;
    private final List<String> dietaryRestrictions;
    private final SpiceLevel spiceLevel;
    private final PriorityLevel priorityLevel;

    // Delivery-specific fields
    private final String deliveryAddress;
    private final LocalDateTime deliveryTime;
    private final Double deliveryFee;
    private final String contactPhone;

    // Payment fields
    private final PaymentMethod paymentMethod;
    private final Double discountPercentage;
    private final Double taxRate;
    private final Double tipAmount;

    // Private constructor - only accessible through Builder
    private RestaurantOrder(Builder builder) {
        this.orderId = builder.orderId;
        this.customerName = builder.customerName;
        this.orderType = builder.orderType;
        this.items = Collections.unmodifiableList(new ArrayList<>(builder.items));
        this.specialInstructions = builder.specialInstructions;
        this.dietaryRestrictions = builder.dietaryRestrictions != null ?
                Collections.unmodifiableList(new ArrayList<>(builder.dietaryRestrictions)) : null;
        this.spiceLevel = builder.spiceLevel;
        this.priorityLevel = builder.priorityLevel;
        this.deliveryAddress = builder.deliveryAddress;
        this.deliveryTime = builder.deliveryTime;
        this.deliveryFee = builder.deliveryFee;
        this.contactPhone = builder.contactPhone;
        this.paymentMethod = builder.paymentMethod;
        this.discountPercentage = builder.discountPercentage;
        this.taxRate = builder.taxRate;
        this.tipAmount = builder.tipAmount;
    }

    // Static method to get builder
    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public OrderType getOrderType() { return orderType; }
    public List<OrderItem> getItems() { return items; }
    public String getSpecialInstructions() { return specialInstructions; }
    public List<String> getDietaryRestrictions() { return dietaryRestrictions; }
    public SpiceLevel getSpiceLevel() { return spiceLevel; }
    public PriorityLevel getPriorityLevel() { return priorityLevel; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public LocalDateTime getDeliveryTime() { return deliveryTime; }
    public Double getDeliveryFee() { return deliveryFee; }
    public String getContactPhone() { return contactPhone; }
    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public Double getDiscountPercentage() { return discountPercentage; }
    public Double getTaxRate() { return taxRate; }
    public Double getTipAmount() { return tipAmount; }

    // Calculate total method
    public double calculateTotal() {
        double subtotal = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // Apply discount
        if (discountPercentage != null && discountPercentage > 0) {
            subtotal = subtotal * (1 - discountPercentage / 100);
        }

        // Add tax
        if (taxRate != null && taxRate > 0) {
            subtotal = subtotal * (1 + taxRate / 100);
        }

        // Add delivery fee
        if (deliveryFee != null) {
            subtotal += deliveryFee;
        }

        // Add tip
        if (tipAmount != null) {
            subtotal += tipAmount;
        }

        return subtotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== RESTAURANT ORDER ===\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Type: ").append(orderType).append("\n");

        if (!items.isEmpty()) {
            sb.append("\nItems:\n");
            items.forEach(item -> sb.append("  - ").append(item).append("\n"));
        }

        if (specialInstructions != null) {
            sb.append("Special Instructions: ").append(specialInstructions).append("\n");
        }

        if (dietaryRestrictions != null && !dietaryRestrictions.isEmpty()) {
            sb.append("Dietary Restrictions: ").append(String.join(", ", dietaryRestrictions)).append("\n");
        }

        if (spiceLevel != null) {
            sb.append("Spice Level: ").append(spiceLevel).append("\n");
        }

        if (priorityLevel != null) {
            sb.append("Priority: ").append(priorityLevel).append("\n");
        }

        if (orderType == OrderType.DELIVERY) {
            sb.append("\nDelivery Info:\n");
            sb.append("  Address: ").append(deliveryAddress).append("\n");
            sb.append("  Phone: ").append(contactPhone).append("\n");
            if (deliveryTime != null) {
                sb.append("  Delivery Time: ").append(deliveryTime).append("\n");
            }
            if (deliveryFee != null) {
                sb.append("  Delivery Fee: $").append(String.format("%.2f", deliveryFee)).append("\n");
            }
        }

        sb.append("\nPayment Info:\n");
        if (paymentMethod != null) {
            sb.append("  Method: ").append(paymentMethod).append("\n");
        }
        if (discountPercentage != null && discountPercentage > 0) {
            sb.append("  Discount: ").append(discountPercentage).append("%\n");
        }
        if (taxRate != null) {
            sb.append("  Tax Rate: ").append(taxRate).append("%\n");
        }
        if (tipAmount != null) {
            sb.append("  Tip: $").append(String.format("%.2f", tipAmount)).append("\n");
        }

        sb.append("  TOTAL: $").append(String.format("%.2f", calculateTotal())).append("\n");
        sb.append("========================\n");

        return sb.toString();
    }

    // Copy method for creating a new builder with existing values (use this when want to change after initialize)
    public Builder copy() {
        Builder builder = new Builder()
                .orderId(this.orderId)
                .customerName(this.customerName)
                .orderType(this.orderType)
                .specialInstructions(this.specialInstructions)
                .spiceLevel(this.spiceLevel)
                .priorityLevel(this.priorityLevel)
                .deliveryAddress(this.deliveryAddress)
                .deliveryTime(this.deliveryTime)
                .deliveryFee(this.deliveryFee)
                .contactPhone(this.contactPhone)
                .paymentMethod(this.paymentMethod)
                .discountPercentage(this.discountPercentage)
                .taxRate(this.taxRate)
                .tipAmount(this.tipAmount);

        // Copy items
        for (OrderItem item : this.items) {
            builder.addItem(item);
        }

        // Copy dietary restrictions
        if (this.dietaryRestrictions != null) {
            for (String restriction : this.dietaryRestrictions) {
                builder.addDietaryRestriction(restriction);
            }
        }

        return builder;
    }

    // NESTED BUILDER CLASS
    public static class Builder {
        // required field
        String orderId;
        String customerName;
        OrderType orderType;

        // optional field
        List<OrderItem> items = new ArrayList<>(); // Initialize here
        String specialInstructions;
        List<String> dietaryRestrictions;
        SpiceLevel spiceLevel;
        PriorityLevel priorityLevel;

        // delivery field
        String deliveryAddress;
        LocalDateTime deliveryTime;
        Double deliveryFee; // Changed to Double for consistency
        String contactPhone;

        // payment field
        PaymentMethod paymentMethod;
        Double discountPercentage;
        Double taxRate;
        Double tipAmount;

        // Required field setters
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder orderType(OrderType orderType) {
            this.orderType = orderType;
            return this;
        }

        // Optional field setters
        public Builder addItem(OrderItem item) {
            if (item != null) {
                // Check for duplicate items (same name and customization)
                if (!this.items.contains(item)) {
                    this.items.add(item);
                } else {
                    throw new IllegalArgumentException("Duplicate item not allowed: " + item.getItemName());
                }
            }
            return this;
        }

        public Builder specialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
            return this;
        }

        public Builder addDietaryRestriction(String restriction) {
            if (restriction != null && !restriction.trim().isEmpty()) {
                if (this.dietaryRestrictions == null) {
                    this.dietaryRestrictions = new ArrayList<>();
                }
                if (!this.dietaryRestrictions.contains(restriction)) {
                    this.dietaryRestrictions.add(restriction);
                }
            }
            return this;
        }

        public Builder spiceLevel(SpiceLevel spiceLevel) {
            this.spiceLevel = spiceLevel;
            return this;
        }

        public Builder priorityLevel(PriorityLevel priorityLevel) {
            this.priorityLevel = priorityLevel;
            return this;
        }

        // Delivery-specific setters
        public Builder deliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder deliveryTime(LocalDateTime deliveryTime) {
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder deliveryFee(Double deliveryFee) {
            this.deliveryFee = deliveryFee;
            return this;
        }

        public Builder contactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        // Payment setters
        public Builder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder discountPercentage(Double discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder taxRate(Double taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        public Builder tipAmount(Double tipAmount) {
            this.tipAmount = tipAmount;
            return this;
        }

        // Validation and build method
        public RestaurantOrder build() {
            // Validate required fields
            if (orderId == null || orderId.trim().isEmpty()) {
                throw new IllegalStateException("Order ID is required");
            }

            if (customerName == null || customerName.trim().isEmpty()) {
                throw new IllegalStateException("Customer name is required");
            }

            if (orderType == null) {
                throw new IllegalStateException("Order type is required");
            }

            if (items.isEmpty()) {
                throw new IllegalStateException("At least one item must be added to the order");
            }

            // Validate delivery-specific requirements
            if (orderType == OrderType.DELIVERY) {
                if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
                    throw new IllegalStateException("Delivery address is required for delivery orders");
                }
                if (contactPhone == null || contactPhone.trim().isEmpty()) {
                    throw new IllegalStateException("Contact phone is required for delivery orders");
                }
            }

            // Validate discount percentage
            if (discountPercentage != null && (discountPercentage < 0 || discountPercentage > 100)) {
                throw new IllegalStateException("Discount percentage must be between 0 and 100");
            }

            // Validate tax rate
            if (taxRate != null && taxRate < 0) {
                throw new IllegalStateException("Tax rate must be non-negative");
            }

            // Validate delivery fee
            if (deliveryFee != null && deliveryFee < 0) {
                throw new IllegalStateException("Delivery fee must be non-negative");
            }

            // Validate tip amount
            if (tipAmount != null && tipAmount < 0) {
                throw new IllegalStateException("Tip amount must be non-negative");
            }

            return new RestaurantOrder(this);
        }
    }
}
