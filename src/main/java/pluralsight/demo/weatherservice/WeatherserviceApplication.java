package pluralsight.demo.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WeatherserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherserviceApplication.class, args);
    }

}
