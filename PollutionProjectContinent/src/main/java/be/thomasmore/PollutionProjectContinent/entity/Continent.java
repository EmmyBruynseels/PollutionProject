package be.thomasmore.PollutionProjectContinent.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "continent")
public class Continent {
    @Id
    private int id;
    private String name;
}
