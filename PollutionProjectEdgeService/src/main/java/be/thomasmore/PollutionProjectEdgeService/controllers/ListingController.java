package be.thomasmore.PollutionProjectEdgeService.controllers;

import be.thomasmore.PollutionProjectEdgeService.models.Country;
import be.thomasmore.PollutionProjectEdgeService.models.CountryPollution;
import be.thomasmore.PollutionProjectEdgeService.models.GenericResponseWrapper;
import be.thomasmore.PollutionProjectEdgeService.models.ListingItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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


    @GetMapping("country/{name}")
    public List<ListingItem> getListingItemsByCountryName(@PathVariable("name") String name){

        Country country = restTemplate.getForObject("http://PollutionProjectCountry/countries/search/findCountryByName?title=" + name, Country.class);


        GenericResponseWrapper wrapper = restTemplate.getForObject("http://PollutionProjectCountryPollution/countryPollutions/search/findPollutionByCountryID?countryid=" + country.getId(), GenericResponseWrapper.class);

        List<CountryPollution> countryPollutions = objectMapper.convertValue(wrapper.get_embedded().get("countryPollutions"), new TypeReference<List<CountryPollution>>() { });

        List<ListingItem> returnList = new ArrayList<>();
        for (CountryPollution cp: countryPollutions) {
            returnList.add(new ListingItem(country.getName(), cp.getPollution(), cp.getYear()));
        }
        return returnList;
    }
}
