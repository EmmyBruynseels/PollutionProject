package be.thomasmore.PollutionProjectContinentPollution.repository;

import be.thomasmore.PollutionProjectContinentPollution.entity.ContinentPollution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface ContinentPollutionRepository extends JpaRepository<ContinentPollution, String> {
    List<ContinentPollution> findAll();
    List<ContinentPollution> findPollutionByContinentID(@Param("continentID")int id);
}
