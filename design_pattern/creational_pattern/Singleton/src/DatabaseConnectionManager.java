public class DatabaseConnectionManager {

    // volatile เมื่อ thread หนึ่งเปลี่ยนค่าตัวแปร volatile thread อื่นๆ จะเห็นการเปลี่ยนแปลงทันที
    private static volatile DatabaseConnectionManager instance;

    // DB config params
    private String databaseUrl;
    private String username;
    private String password;
    private String driverClassName;
    private int maxConnections;
    private int currentConnections;
    private boolean isConnected;
    private long connectionTimestamp;
    private boolean isConfigured;

    private DatabaseConnectionManager(){
        this.databaseUrl = "mysql://localhost:0000/myapp";
        this.username = "admin";
        this.password = "password123";
        this.driverClassName = "com.mysql.cj.jdbc.Driver";
        this.maxConnections = 10;
        this.currentConnections = 0;
        this.isConnected = false;
        this.connectionTimestamp = 0L;
        this.isConfigured = false;
    }

    // singleton instance getter using double-checked locking
    public static DatabaseConnectionManager getInstance(){
        if (instance == null){
            synchronized (DatabaseConnectionManager.class){ // ใช้ lock คลาส DatabaseConnectionManager ไว้ เพื่อป้องกันไม่ให้เธรดอื่นเข้ามาใน block นี้พร้อมกัน
                if (instance == null){ // ตรวจสอบอีกครั้งว่า instance ยังเป็น null อยู่ไหม (เช็คครั้งที่สอง) เพราะระหว่างที่รอ lock อาจมีเธรดอื่นสร้าง instance ไปแล้ว
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    // configure DB (can only call once)
    public synchronized boolean configure(String url, String username, String password){
        if (isConfigured){
            System.out.println("Database is already configured.");
            return false;
        }

        if (url == null || url.trim().isEmpty() ||
            username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()){
            System.out.println("Invalid configuration parameters. All fields are required.");
            return false;
        }

        this.databaseUrl = url.trim();
        this.username = username.trim();
        this.password = password.trim();
        this.isConfigured = true;

        System.out.println("Database configuration updated successfully.");
        return true;
    }

    // establish database connection
    public synchronized boolean connect(){
        if(isConnected){
            System.out.println("Already connected to database.");
            return true;
        }

        if (currentConnections >= maxConnections){
            System.out.println("Maximum connections reached. Cannot establish new connection.");
            return false;
        }

        try {
            System.out.println("Connecting to database: " + databaseUrl);
            System.out.println("Using driver: " + driverClassName);

            // simulation delay
            Thread.sleep(1000);

            this.isConnected = true;
            this.currentConnections += 1;
            this.connectionTimestamp = System.currentTimeMillis();

            System.out.println("Successfully connected to database!");
            return true;
        } catch (InterruptedException e){ // หากมี thread อื่นมาขัดจังหวะระหว่างที่ thread นี้กำลัง "หลับ" (sleep) อยู่ จะเกิด InterruptedException
            System.out.println("Connection interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
            return false;
        } catch (Exception e) { // another exception
            System.out.println("Failed to connect to database: " + e.getMessage());
            return false;
        }
    }

    // disconnect database connection
    public synchronized boolean disconnect(){
        if (!isConnected) {
            System.out.println("Already disconnected.");
            return false;
        }

        try{
            System.out.println("Disconnect from database...");
            Thread.sleep(500);

            this.isConnected = false;
            this.currentConnections = Math.max(0, currentConnections - 1);

            System.out.println("Successfully disconnected from database.");
            return true;
        } catch (InterruptedException e){
            System.out.println("Connection interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
            return false;
        } catch (Exception e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            return false;
        }
    }

    // check current connection status
    public boolean isConnected() {
        return this.isConnected;
    }

    // Get connection information
    public String getConnectionInfo() {
        String status = isConnected ? "CONNECTED" : "DISCONNECTED";
        long uptime = isConnected ? getConnectionUptime() : 0;

        return String.format("Database: %s | User: %s | Status: %s | Uptime: %d seconds",
                              databaseUrl, username, status, uptime);
    }

    // calculate connection uptime in seconds
    public long getConnectionUptime(){
        if (!isConnected || connectionTimestamp == 0){
            return 0;
        }
        return (System.currentTimeMillis() - connectionTimestamp) / 1000;
    }

    // get number of current connections
    public int getCurrentConnections(){
        return this.currentConnections;
    }

    // get max allowed connection
    public int getMaxConnections(){
        return this.getMaxConnections();
    }

    // set maximum connection limit
    public synchronized void setMaxConnections(int maxConnections) {
        if (maxConnections > 0){
            this.maxConnections = maxConnections;
            System.out.println("Maximum connections updated to: " + maxConnections);
        } else {
            System.out.println("Invalid maximum connections value. Must be greater than 0.");
        }
    }

    // Prevent cloning
    // throws CloneNotSupportedException = แจ้งไว้ที่หัว method ว่า method นี้ อาจจะโยน exception นี้ออกมา
    // throw new CloneNotSupportedException(...) = คือการ โยน exception จริง ๆ ระหว่างการทำงาน
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton instance is not allowed.");
    }
}