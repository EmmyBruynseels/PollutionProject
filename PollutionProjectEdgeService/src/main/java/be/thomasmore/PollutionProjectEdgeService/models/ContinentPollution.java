package be.thomasmore.PollutionProjectEdgeService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class ContinentPollution {

    private int id;
    private int continentID;
    private int year;
    private double pollution;
}
