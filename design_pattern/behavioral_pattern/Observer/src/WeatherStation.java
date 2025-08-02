import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private WeatherData weatherData;

    public WeatherStation(){
        observers = new ArrayList<>();
        weatherData = new WeatherData(0,0,0);
    }

    public void setWeatherData(float temperature, float humidity, float pressure){
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
        weatherData.setPressure(pressure);
        notifyObserver();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    @Override
    public void attach(Observer observer){
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        }
    }
}
