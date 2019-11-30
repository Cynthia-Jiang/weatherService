package pluralsight.demo.weatherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pluralsight.demo.weatherservice.entity.City;
import pluralsight.demo.weatherservice.entity.WeatherResponse;
import pluralsight.demo.weatherservice.service.WeatherDateServiceImpl;


@Controller
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    WeatherDateServiceImpl weatherDateService;

    @GetMapping("/")
    public String index(Model model) {
        City city = new City();
        city.setName("北京");
        model.addAttribute("city", city);
        return "index";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String queryWeather(@ModelAttribute City city, Model m) {
        WeatherResponse res = weatherDateService.getDateByCityName(city.getName());
        city.setWeather(res);

        m.addAttribute("city", city);
        m.addAttribute("forecasts", city.getWeather().getData().getForecast());
        m.addAttribute("yesterday", city.getWeather().getData().getYesterday());
        m.addAttribute("weather", city.getWeather().getData());

        return "weather";
    }

//    @RequestMapping("/cityName")
//    public String getReportByCityName( @PathVariable("cityName") String cityName)
//    {
//        try{
//            String result = weatherDateService.getDateByCityName(cityName).toString();
//            return result;
//
//        }catch (Exception e){
//            return "call failed!";
//        }
//       // return weatherDateService.getDateByCityName(cityName).toString();
//    }



}
