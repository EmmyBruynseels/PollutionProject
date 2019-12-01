package be.thomasmore.PollutionProjectCountry.repository;

import be.thomasmore.PollutionProjectCountry.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface CountryRepository extends JpaRepository<Country,String> {
    Country findCountryByName(@Param("name") String name);
    Country findCountryById(@Param("id") String id);
    List<Country> findCountriesByContinentID(@Param("continentID") int continentID);
    //long deleteCountryById( @Param("id")int id);
}
