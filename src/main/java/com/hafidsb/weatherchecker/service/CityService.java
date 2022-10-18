package com.hafidsb.weatherchecker.service;

import com.hafidsb.weatherchecker.entity.CityEntity;
import com.hafidsb.weatherchecker.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public List<CityEntity> findAll() {
        return repository.findAll();
    }

    public List<CityEntity> findAllCapitals() {
        List<String> capitals =
                Arrays.asList(
                        "Canberra", "Sydney", "Darwin",
                        "Brisbane", "Adelaide", "Hobart",
                        "Melbourne", "Perth"
                );

        return repository.findByNameInAndCapitalNot(capitals, "");
    }
}
