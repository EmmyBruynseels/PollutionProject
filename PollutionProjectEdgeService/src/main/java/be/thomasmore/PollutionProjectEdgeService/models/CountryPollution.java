package be.thomasmore.PollutionProjectEdgeService.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryPollution {
    private int id;
    private int countryID;
    private int year;
    private double pollution;
}
