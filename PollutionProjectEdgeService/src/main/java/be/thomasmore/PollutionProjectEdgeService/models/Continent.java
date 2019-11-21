package be.thomasmore.PollutionProjectEdgeService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
public class Continent {
    private Integer continentId;
    private String name;
    private List<ContinentPollution> continentPollutions;
}
