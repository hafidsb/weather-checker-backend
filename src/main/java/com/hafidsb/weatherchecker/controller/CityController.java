package com.hafidsb.weatherchecker.controller;

import com.hafidsb.weatherchecker.entity.CityEntity;
import com.hafidsb.weatherchecker.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityEntity> all() {
        return cityService.findAll();
    }

}
