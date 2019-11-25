package pluralsight.demo.weatherservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pluralsight.demo.weatherservice.entity.WeatherResponse;
import pluralsight.demo.weatherservice.entity.city;
import pluralsight.demo.weatherservice.service.WeatherDateService;

import javax.validation.Valid;


@SpringBootApplication
@RestController
@Controller
@RequestMapping(value = "/weather", method = RequestMethod.GET)
public class WeatherController {

    private WeatherDateService weatherDateService;
    private city city;

    @Autowired
    public  WeatherController(WeatherDateService weatherDateService, city city){
        this.weatherDateService= weatherDateService;
        this.city= city;
    }
    @RequestMapping("/")
    public String test(Model m){
        m.addAttribute("city",this.city);

        return "index";
       // return "test for home page";
        //return weatherDateService.getDateByCityName("北京").toString();
    }
    @RequestMapping("/cityName/{cityName}")
    public String getReportByCityName( @PathVariable("cityName") String cityName)
    {
        try{
            String result = weatherDateService.getDateByCityName(cityName).toString();
            return result;

        }catch (Exception e){
            return "call failed!";
        }
       // return weatherDateService.getDateByCityName(cityName).toString();
    }

    @RequestMapping("/query/{cityName}")
    public String queryWeather(/*@Valid city city,*/@PathVariable("cityName") String cityName,  Model m){
        this.city.setName(cityName);
        this.city.setWeather(weatherDateService.getDateByCityName(city.getName()));

        m.addAttribute("city",this.city);
        m.addAttribute("forecasts",this.city.getWeather().getData().getForecast());
        m.addAttribute("yesterday",this.city.getWeather().getData().getYesterday());
        m.addAttribute("weather",this.city.getWeather().getData());

        return "weather";
    }

}
