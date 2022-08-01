package com.dns214.HRSoftware.karyawan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class KaryawanConfig {
    @Bean
    CommandLineRunner commandLineRunner(KaryawanRepository repository){
        return args -> {
            Karyawan david = new Karyawan(
                    "David",
                    "Beckham",
                    "david@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Karyawan ben = new Karyawan(
                    "Ben",
                    "Graham",
                    "Bengraham@gmail.com",
                    LocalDate.of(1992, Month.JANUARY, 5)
            );

            repository.saveAll(
                    List.of(david, ben)
            );
        };
    }
}
