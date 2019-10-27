package be.thomasmore.PollutionProjectEdgeService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingItem {
    private String countryName;
    private double pollution;
    private int year;
}
