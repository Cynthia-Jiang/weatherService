package pluralsight.demo.weatherservice.service;

import pluralsight.demo.weatherservice.entity.WeatherResponse;

public interface WeatherDateService {

    //根据城市id查询天气

    WeatherResponse getDateByCityId(String cityId);

    //根据城市名字查询天气

    WeatherResponse getDateByCityName(String cityName);
}
