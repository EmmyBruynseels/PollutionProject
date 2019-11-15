package be.thomasmore.PollutionProjectCountryPollution.entity;

import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="countrypollution")
@Data
@NoArgsConstructor
public class CountryPollution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="countryID")
    private int countryID;
    @Column(name="year")
    private int year;
    @Column(name="pollution")
    private double pollution;
}

