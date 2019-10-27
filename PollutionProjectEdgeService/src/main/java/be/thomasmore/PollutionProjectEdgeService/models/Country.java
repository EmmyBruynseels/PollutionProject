package be.thomasmore.PollutionProjectEdgeService.models;

import lombok.Data;
import lombok.NoArgsConstructor;

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


}
