package com.hafidsb.weatherchecker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hafidsb.weatherchecker.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
@SuppressWarnings("unused variable")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public JsonNode getWeather(
            @RequestParam String lat,
            @RequestParam String lon
    ) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = weatherService.getWeather(lat, lon);

        try {
            return mapper.readTree(jsonString);
        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    @GetMapping("/city/{id}")
    public JsonNode getWeatherByCityId(
            @PathVariable Long id
    ) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = weatherService.getWeatherByCityId(id);

        try {
            return mapper.readTree(jsonString);
        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }
}
