package com.helloworld.spring.database;

import lombok.extern.slf4j.Slf4j;
import com.helloworld.spring.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.helloworld.spring.repository.EmployeeRepository;

@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args->{
            log.info("Preloading" + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading" + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}
