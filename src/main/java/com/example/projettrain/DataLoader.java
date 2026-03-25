package com.example.projettrain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class DataLoader {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Bean
    public CommandLineRunner loadData() {
        return args -> logger.info("Base de données H2 initialisée avec les données de test");
    }

    @Bean
    public void RecupereLEtatDUneGare() {

    }
}

