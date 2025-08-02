public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Subject weatherStation;

    public CurrentConditionsDisplay(Subject weatherStation){
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }

    public void display(){
        System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
