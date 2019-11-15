package be.thomasmore.PollutionProjectEdgeService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class CountryPollution {
    private int id;
    private int countryID;
    private int year;
    private double pollution;
}
