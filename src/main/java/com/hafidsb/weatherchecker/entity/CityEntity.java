package com.hafidsb.weatherchecker.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "cities")
@SuppressWarnings("unused variable")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonProperty("city_name")
    private String name;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;

    @JsonProperty("capital")
    private String capital;
}
