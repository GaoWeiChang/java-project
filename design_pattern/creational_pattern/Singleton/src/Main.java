public class Main {
    public static void main(String[] args) {
        System.out.println("=== Database Connection Manager - Singleton Pattern Demo ===\n");

        // Test 1: Singleton instance verification
        System.out.println("1. Testing Singleton Instance:");
        DatabaseConnectionManager manager1 = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager manager2 = DatabaseConnectionManager.getInstance();

        System.out.println("manager1 == manager2: " + (manager1 == manager2));
        System.out.println("Same instance hash: " + (manager1.hashCode() == manager2.hashCode()));
        System.out.println();

        // Test 2: Configuration
        System.out.println("2. Testing Configuration:");
        manager1.configure("jdbc:postgresql://localhost:5432/testdb", "testuser", "testpass");

        manager1.configure("jdbc:mysql://localhost:3306/another", "another", "pass");
        System.out.println();

        // Test 3: Connection operations
        System.out.println("3. Testing Connection Operations:");
        System.out.println("Initial connection status: " + manager1.isConnected());
        System.out.println("Connection info: " + manager1.getConnectionInfo());
        System.out.println();

        manager1.connect();
        System.out.println("After connection - Status: " + manager1.isConnected());
        System.out.println("Current connections: " + manager1.getCurrentConnections());
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Connection info after 2 seconds: " + manager1.getConnectionInfo());
        System.out.println();

        // Test 4: Thread safety demonstration
        System.out.println("4. Testing Thread Safety:");
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                DatabaseConnectionManager manager = DatabaseConnectionManager.getInstance();
                System.out.println("Thread " + threadId + " got instance: " + manager.hashCode());
            });
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        // Test 5: Disconnect
        System.out.println("5. Testing Disconnection:");
        manager1.disconnect();
        System.out.println("Final connection info: " + manager1.getConnectionInfo());

        System.out.println("\n=== Demo Complete ===");
    }
}
