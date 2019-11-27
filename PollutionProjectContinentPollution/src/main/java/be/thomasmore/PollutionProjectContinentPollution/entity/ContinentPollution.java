package be.thomasmore.PollutionProjectContinentPollution.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="continentpollution")
@Data
@NoArgsConstructor
public class ContinentPollution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="continentID")
    private int continentID;
    @Column(name="year")
    private int year;
    @Column(name="pollution")
    private double pollution;
}