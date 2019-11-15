package be.thomasmore.PollutionProjectContinent.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Continents")
@NoArgsConstructor
public class Continent {
    @Id
    private ObjectId id;

    private Integer continentId;
    private String name;
}
