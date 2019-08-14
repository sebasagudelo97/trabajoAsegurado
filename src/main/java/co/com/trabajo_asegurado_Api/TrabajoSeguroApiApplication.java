package co.com.trabajo_asegurado_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.com.trabajo_asegurado")
@EnableJpaRepositories(basePackages = "co.com.trabajo_asegurado")
@EntityScan(basePackages = "co.com.trabajo_asegurado")
public class TrabajoSeguroApiApplication  {

    public static void main(String[] args){
        SpringApplication.run(TrabajoSeguroApiApplication.class,args);
    }
}
