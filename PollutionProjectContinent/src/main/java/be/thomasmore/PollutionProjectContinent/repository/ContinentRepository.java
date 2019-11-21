package be.thomasmore.PollutionProjectContinent.repository;

import be.thomasmore.PollutionProjectContinent.entity.Continent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContinentRepository  extends MongoRepository<Continent, String> {
    Continent findContinentByContinentId(@Param("continentId") int continentId);
    Continent findContinentByName(@Param("name") String name);
}
