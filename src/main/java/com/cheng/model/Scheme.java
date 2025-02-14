package com.cheng.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;
    private java.sql.Date plantingDate;
    private String targetProduction;
    private Double expectedInvestment;
    private Double expectedOutput;
    private Double waterRequirement;
    private Double nitrogen;
    private Double phosphorus;
    private Double potassium;
}
