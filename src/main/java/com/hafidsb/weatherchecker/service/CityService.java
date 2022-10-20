package com.hafidsb.weatherchecker.service;

import com.hafidsb.weatherchecker.entity.CityEntity;
import com.hafidsb.weatherchecker.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public Optional<CityEntity> findById(Long id) {
        return repository.findById(id);
    }

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

        return repository.findByNameInAndCapitalNotOrderByNameAsc(capitals, "");
    }
}
