package pluralsight.demo.weatherservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class weather implements Serializable
{
    private static final long serialVersionUID = 1L;

    private yesterday yesterday;
    //七日预测
    @JsonProperty("forecast")
    private List<Forecast> forecast;

    private String city;

    //空气指数
    private String aqi;

    //提示
    private String ganmao;

    //温度
    private String wendu;

    public yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    @Override
    public String toString() {
        return "WeatherData [yesterday=" + yesterday + ", forecast=" + forecast + ", city=" + city + ", aqi=" + aqi
                + ", ganmao=" + ganmao + ", wendu=" + wendu + "]";
    }
}
