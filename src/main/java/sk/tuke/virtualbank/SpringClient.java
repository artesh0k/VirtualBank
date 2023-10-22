package sk.tuke.virtualbank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tuke.virtualbank.core.Console;
import sk.tuke.virtualbank.core.NumberGenerator;
import sk.tuke.virtualbank.service.*;

@SpringBootApplication
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.virtualbank.server.*"))
public class SpringClient {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runner(Console console){
        return s -> console.play();
    }

    @Bean
    public Console console(){
        return new Console();
    }

    @Bean
    public NumberGenerator numberGenerator(){ return new NumberGenerator();}

    @Bean
    public CustomerService customerService(){ return new CustomerServiceRestClient();}

    @Bean
    public AccountService accountService(){ return new AccountServiceJPA();}

    @Bean
    public PaymentService paymentService(){ return new PaymentServiceJPA();}

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
