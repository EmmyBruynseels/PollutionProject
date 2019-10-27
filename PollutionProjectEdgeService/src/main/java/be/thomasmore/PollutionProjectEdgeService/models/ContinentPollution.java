package be.thomasmore.PollutionProjectEdgeService.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContinentPollution {

    private int id;
    private int continentID;
    private int year;
    private double pollution;
}
