package pluralsight.demo.weatherservice.entity;

public class city {
    private String name;
    private WeatherResponse weatherResponse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeather(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public WeatherResponse getWeather() {
        return weatherResponse;
    }
}
