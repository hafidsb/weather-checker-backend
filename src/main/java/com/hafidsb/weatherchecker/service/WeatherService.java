package com.hafidsb.weatherchecker.service;

import com.hafidsb.weatherchecker.entity.CityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final CityService cityService;

    @Value("${WEATHER_API_BASE_URL}")
    @SuppressWarnings("UnusedDeclaration")
    private String apiURL;

    @Value("${WEATHER_API_KEY}")
    @SuppressWarnings("UnusedDeclaration")
    private String apiKey;

    public String getWeather(String latitude, String longitude) {
        return WebClient.create(this.apiURL)
                .get()
                .uri(uriBuilder -> uriBuilder.path("/weather")
                        .queryParam("appid", this.apiKey)
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getWeatherByCityId(Long id) {
        CityEntity city = cityService.findById(id).orElseThrow();
        return this.getWeather(city.getLatitude(), city.getLongitude());
    }
}
