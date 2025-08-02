public class StatisticsDisplay implements Observer {
    private float minTemp = Float.MIN_VALUE;
    private float maxTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;
    private Subject weatherStation;

    public StatisticsDisplay(Subject weatherStation){
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }

    public void display() {
        float avgTemp = tempSum / numReadings;
        System.out.println("Avg/Max/Min temperature: " +
                String.format("%.1f", avgTemp) + "°C/" +
                maxTemp + "°C/" + minTemp + "°C");
    }

    @Override
    public void update(float temperature, float humidity, float pressure){
        tempSum += temperature;
        numReadings += 1;

        if (temperature > maxTemp){
            maxTemp = temperature;
        }
        if (temperature < minTemp){
            minTemp = temperature;
        }

        display();
    }
}
