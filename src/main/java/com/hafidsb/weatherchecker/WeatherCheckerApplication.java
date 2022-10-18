package com.hafidsb.weatherchecker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hafidsb.weatherchecker.entity.CityEntity;
import com.hafidsb.weatherchecker.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
@SuppressWarnings("unused method")
public class WeatherCheckerApplication {

	@Value("${INITIAL_CITY_JSON_PATH}")
	private String jsonPath;

	public static void main(String[] args) {
		SpringApplication.run(WeatherCheckerApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner demoData(CityRepository repository) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				List<CityEntity> cities =
						Arrays.asList(
								mapper.readValue(
										new File(jsonPath),
										CityEntity[].class
								));
				repository.saveAll(cities);
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		};
	}

}
