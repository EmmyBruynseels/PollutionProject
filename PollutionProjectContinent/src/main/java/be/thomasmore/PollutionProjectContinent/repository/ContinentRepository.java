package be.thomasmore.PollutionProjectContinent.repository;

import be.thomasmore.PollutionProjectContinent.entity.Continent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContinentRepository  extends MongoRepository<Continent,String> {
    List<Continent> findContinentById(@Param("id") Integer continentId);
}
