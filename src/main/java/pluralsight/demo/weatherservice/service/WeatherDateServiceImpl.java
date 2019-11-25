package pluralsight.demo.weatherservice.service;
import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import pluralsight.demo.weatherservice.entity.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.data.redis.core.ValueOperations;

@Service
public class WeatherDateServiceImpl implements WeatherDateService {

    @Autowired
    private RestTemplate restTemplate;

    private final String WEATHER_API="http://wthrcdn.etouch.cn/weather_mini";

    @Override
    public WeatherResponse getDateByCityId(String cityId)
    {
        String uri=WEATHER_API+"?citykey="+cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDateByCityName(String cityName)
    {
        String uri=WEATHER_API+"?city="+cityName;
        return this.doGetWeatherData(uri);
    }

    private WeatherResponse doGetWeatherData(String uri)
    {
        ResponseEntity<String> response=restTemplate.getForEntity(uri, String.class);
        String strBody=null;
        if(response.getStatusCodeValue()==200){
            strBody=response.getBody();
        }
        //jackson库中的类
        ObjectMapper mapper= new ObjectMapper();
        WeatherResponse weather=null;
        try {
            //mapper.readValue是将json结构转换成成java对象
            // mapper.writeValue是将java对象转成json结构
            weather=mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("throw exception:" + ExceptionUtils.getStackTrace(e));
        }
        return weather;
    }

}
