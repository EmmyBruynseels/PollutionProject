package be.thomasmore.PollutionProjectContinentPollution.repository;

import be.thomasmore.PollutionProjectContinentPollution.entity.ContinentPollution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContinentPollutionRepository extends JpaRepository<ContinentPollution, String> {
    List<ContinentPollution> findAll();

}
