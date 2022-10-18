package com.hafidsb.weatherchecker.controller;

import com.hafidsb.weatherchecker.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
@SuppressWarnings("unused variable")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public String getWeather(
            @RequestParam String lat,
            @RequestParam String lon
    ) {
        return weatherService.getWeather(lat, lon);
    }

    @GetMapping("/city/{id}")
    public String getWeatherByCityId(
            @PathVariable Long id
    ) {
        return weatherService.getWeatherByCityId(id);
    }
}
