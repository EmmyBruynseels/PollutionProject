package be.thomasmore.PollutionProjectCountryPollution.repository;

import be.thomasmore.PollutionProjectCountryPollution.entity.CountryPollution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface CountryPollutionRepository extends JpaRepository<CountryPollution,String> {
    List<CountryPollution> findAll();
    CountryPollution findPollutionByCountryID(@Param("countryID")int id)
}
