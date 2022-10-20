package com.hafidsb.weatherchecker.repository;

import com.hafidsb.weatherchecker.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByNameInAndCapitalNotOrderByNameAsc(List<String> citiesList, String empty);
}
