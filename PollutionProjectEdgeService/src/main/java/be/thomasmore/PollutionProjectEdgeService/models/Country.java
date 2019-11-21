package be.thomasmore.PollutionProjectEdgeService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Country {
    private int id;
    private String name;
    private int continentID;
    private String countryCode;
    private int population;
    private int area;
    private double industry;
    private double agriculture;
    private double popDensity;
    private double literacy;
    private List<CountryPollution> countryPollutions;
}