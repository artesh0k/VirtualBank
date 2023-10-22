package sk.tuke.virtualbank.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.virtualbank.core.Console;
import sk.tuke.virtualbank.core.NumberGenerator;
import sk.tuke.virtualbank.service.*;

@SpringBootApplication
@Configuration
public class VirtualBankServer {
    public static void main(String[] args) {
        SpringApplication.run(VirtualBankServer.class);
    }

    @Bean
    public CustomerService customerService(){ return new CustomerServiceJPA();}

    @Bean
    public AccountService accountService(){ return new AccountServiceJPA();}

    @Bean
    public PaymentService paymentService(){ return new PaymentServiceJPA();}


}
