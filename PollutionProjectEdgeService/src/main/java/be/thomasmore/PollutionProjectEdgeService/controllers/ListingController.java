package be.thomasmore.PollutionProjectEdgeService.controllers;

import be.thomasmore.PollutionProjectEdgeService.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    // Return list of all countries
    @GetMapping("countries/")
    public List<Country> getAllCountries() {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountry/countries/", GenericResponseWrapper.class);
        List<Country> countries = objectMapper.convertValue(wrapper.get_embedded().get("countries"), new TypeReference<List<Country>>() {
        });

        // Order continents by name
        Collections.sort(countries, Comparator.comparing(Country::getName));

        return countries;

    }

    // Return country for given id
    @GetMapping("country/{id}")
    public Country getCountryById(@PathVariable("id") int id) {

        return restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountryById?id=" + id, Country.class);

    }

    // Return list of countries for given continentId
    @GetMapping("countryByContinent/{id}")
    public List<Country> getCountryByContinent(@PathVariable("id") int id) {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountriesByContinentID?continentID=" + id, GenericResponseWrapper.class);
        List<Country> countries = objectMapper.convertValue(wrapper.get_embedded().get("countries"), new TypeReference<List<Country>>() {
        });

        // Order continents by name
        Collections.sort(countries, Comparator.comparing(Country::getName));

        return countries;

    }

    // Return country with pollution for given id
    @GetMapping("countryPollution/{id}")
    public Country getCountryPollutionByCountryID(@PathVariable("id") int id) {

        Country country = restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountryById?id=" + id, Country.class);

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountryPollution/countryPollutions/search/findPollutionByCountryID?countryID=" + country.getId(), GenericResponseWrapper.class);
        List<CountryPollution> countryPollutions = objectMapper.convertValue(wrapper.get_embedded().get("countryPollutions"), new TypeReference<List<CountryPollution>>() {
        });

        // Order pollutions by year
        Collections.sort(countryPollutions, Comparator.comparing(cp -> (cp.getYear() + "")));

        country.setCountryPollutions(countryPollutions);

        return country;

    }

    // Return list of all continents
    @GetMapping("continents/")
    public List<Continent> getAllContinents() {

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectContinent/continents/", GenericResponseWrapper.class);
        List<Continent> continents = objectMapper.convertValue(wrapper.get_embedded().get("continents"), new TypeReference<List<Continent>>() {
        });

        // Order continents by name
        Collections.sort(continents, Comparator.comparing(Continent::getName));

        return continents;

    }

    // Return continent for given name
    @GetMapping("continent/{name}")
    public Continent getContinentByName(@PathVariable("name") String name) {

        return restTemplate.getForObject("http://PollutionProjectContinent/continents/search/findContinentByName?name=" + name, Continent.class);

    }

    // Return continent for given id
    @GetMapping("continentById/{id}")
    public Continent getContinentById(@PathVariable("id") int id) {

        return restTemplate.getForObject("http://PollutionProjectContinent/continents/search/findContinentByContinentId?continentId=" + id, Continent.class);

    }

    // Return continent with pollution for given id
    @GetMapping("continentPollution/{id}")
    public Continent getContinentPollutionByContinentId(@PathVariable("id") int id) {

        Continent continent = restTemplate.getForObject("http://PollutionProjectContinent/continents/search/findContinentByContinentId?continentId=" + id, Continent.class);

        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectContinentPollution/continentPollutions/search/findPollutionByContinentID?continentID=" + continent.getContinentId(), GenericResponseWrapper.class);
        List<ContinentPollution> continentPollutions = objectMapper.convertValue(wrapper.get_embedded().get("continentPollutions"), new TypeReference<List<ContinentPollution>>() {
        });

        // Order pollutions by year
        Collections.sort(continentPollutions, Comparator.comparing(cp -> (cp.getYear() + "")));

        continent.setContinentPollutions(continentPollutions);

        return continent;

    }

    // Insert country
    @PostMapping("country/")
    public void postCountry(@RequestBody Country country) {
        restTemplate.postForEntity("http://PollutionProjectCountry/countries/", country, String.class);
    }

    // Update country
    @PutMapping("country/")
    public void putCountry(@RequestBody Country country) {
        restTemplate.put("http://PollutionProjectCountry/countries/" + country.getId(), country, String.class);
    }

    // Delete country
    @DeleteMapping("country/{id}")
    private void deleteCountry(@PathVariable("id") int id) {
        // Get all countryPollution for countryId from database
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountryPollution/countryPollutions/search/findPollutionByCountryID?countryID=" + id, GenericResponseWrapper.class);
        List<CountryPollution> countryPollutions = objectMapper.convertValue(wrapper.get_embedded().get("countryPollutions"), new TypeReference<List<CountryPollution>>() {
        });

        // Delete all countryPollution in database
        for (CountryPollution countryPollution : countryPollutions) {
            this.deleteCountryPollution(countryPollution.getId());
        }

        // Delete country in database
        restTemplate.delete("http://PollutionProjectCountry/countries/" + id);
    }

    // Insert countrypollution
    @PostMapping("countryPollution/")
    public void postCountryPollution(@RequestBody CountryPollution countryPollution) {
        restTemplate.postForEntity("http://PollutionProjectCountryPollution/countryPollutions/", countryPollution, String.class);
    }

    // Update countrypollution
    @PutMapping("countryPollution/")
    public void putCountryPollution(@RequestBody CountryPollution countryPollution) {
        restTemplate.put("http://PollutionProjectCountryPollution/countryPollutions/" + countryPollution.getId(), countryPollution, String.class);
    }

    // Delete countrypollution
    @DeleteMapping("countryPollution/{id}")
    private void deleteCountryPollution(@PathVariable("id") int id) {
        restTemplate.delete("http://PollutionProjectCountryPollution/countryPollutions/" + id);
    }

    // Insert continentPollution
    @PostMapping("continentPollution/")
    public void postContinentPollution(@RequestBody ContinentPollution continentPollution) {
        restTemplate.postForEntity("http://PollutionProjectContinentPollution/continentPollutions/", continentPollution, String.class);
    }

    // Update continentpollution
    @PutMapping("continentPollution/")
    public void putContinentPollution(@RequestBody ContinentPollution continentPollution) {
        restTemplate.put("http://PollutionProjectContinentPollution/continentPollutions/" + continentPollution.getId(), continentPollution, String.class);
    }

    // Delete continentpollution
    @DeleteMapping("continentPollution/{id}")
    private void deleteContinentPollution(@PathVariable("id") int id) {
        restTemplate.delete("http://PollutionProjectContinentPollution/continentPollutions/" + id);
    }

}
