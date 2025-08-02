public class Main {
    public static void main(String[] args) {
        // publisher
        WeatherStation weatherStation = new WeatherStation();

        // subscribers
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

        System.out.println("Initial weather readings:");
        weatherStation.setWeatherData(25.5f, 65f, 1013.25f);

        System.out.println("\n--- Weather Update 1 ---");
        weatherStation.setWeatherData(27.2f, 70f, 1015.8f);

        System.out.println("\n--- Weather Update 2 ---");
        weatherStation.setWeatherData(23.1f, 55f, 1010.3f);

        System.out.println("\n--- Weather Update 3 ---");
        weatherStation.setWeatherData(30.0f, 45f, 1020.5f);




        System.out.println("\n--- Removing Statistics Display ---");
        weatherStation.detach(statisticsDisplay);

        System.out.println("\n--- Weather Update 4 (without statistics) ---");
        weatherStation.setWeatherData(28.5f, 60f, 1018.2f);

    }
}
