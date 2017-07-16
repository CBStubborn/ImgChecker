package personal.img.checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Stubborn on 2017/4/8.
 */
@SpringBootApplication
@PropertySource("classpath:conf/jpa.properties")
public class WebAppInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebAppInitializer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebAppInitializer.class, args);
    }
}
