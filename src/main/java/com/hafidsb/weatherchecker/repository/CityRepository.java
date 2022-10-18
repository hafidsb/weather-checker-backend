package com.hafidsb.weatherchecker.repository;

import com.hafidsb.weatherchecker.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
