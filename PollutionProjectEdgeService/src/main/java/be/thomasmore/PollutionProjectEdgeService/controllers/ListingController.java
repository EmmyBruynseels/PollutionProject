package be.thomasmore.PollutionProjectEdgeService.controllers;

import be.thomasmore.PollutionProjectEdgeService.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("countries/")
    public List<Country> getAllCountries(){

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountry/countries/", GenericResponseWrapper.class);
        return objectMapper.convertValue(wrapper.get_embedded().get("countries"), new TypeReference<List<Country>>() { });

    }

    @GetMapping("country/{name}")
    public Country getCountryByName(@PathVariable("name") String name){

        return restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountryByName?name=" + name, Country.class);

    }

    @GetMapping("countryPollution/{name}")
    public Country getCountryPollutionByCountryName(@PathVariable("name") String name){

        Country country = restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountryByName?name=" + name, Country.class);

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountryPollution/countryPollutions/search/findPollutionByCountryID?countryID=" + country.getId(), GenericResponseWrapper.class);
        List<CountryPollution> countryPollutions = objectMapper.convertValue(wrapper.get_embedded().get("countryPollutions"), new TypeReference<List<CountryPollution>>() { });

        country.setCountryPollutions(countryPollutions);

        return country;
    }

    @GetMapping("continents/")
    public List<Continent> getAllContinents(){

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectContinent/continents/", GenericResponseWrapper.class);
        return objectMapper.convertValue(wrapper.get_embedded().get("continents"), new TypeReference<List<Continent>>() { });

    }

    @GetMapping("continent/{name}")
    public Continent getContinentByName(@PathVariable("name") String name){

        return restTemplate.getForObject("http://PollutionProjectContinent/continents/search/findContinentByName?name=" + name, Continent.class);

    }

    @GetMapping("continentPollution/{name}")
    public Continent getContinentPollutionByContinentName(@PathVariable("name") String name){

        Continent continent = restTemplate.getForObject("http://PollutionProjectContinent/continents/search/findContinentByName?name=" + name, Continent.class);

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectContinentPollution/continentPollutions/search/findPollutionByContinentID?continentID=" + continent.getContinentId(), GenericResponseWrapper.class);
        List<ContinentPollution> continentPollutions = objectMapper.convertValue(wrapper.get_embedded().get("continentPollutions"), new TypeReference<List<ContinentPollution>>() { });

        continent.setContinentPollutions(continentPollutions);

        return continent;
    }
}