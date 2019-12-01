package be.thomasmore.PollutionProjectCountry.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="continentID")
    private int continentID;

    @Column(name="countrycode")
    private String countryCode;

    @Column(name="population")
    private int population;

    @Column(name="area")
    private int area;

    @Column(name="industry")
    private double industry;

    @Column(name="agriculture")
    private double agriculture;

    @Column(name="popdensity")
    private double popDensity;

    @Column(name="literacy")
    private double literacy;


}
