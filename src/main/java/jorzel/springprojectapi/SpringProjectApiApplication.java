package jorzel.springprojectapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringProjectApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjectApiApplication.class, args);
    }

}
