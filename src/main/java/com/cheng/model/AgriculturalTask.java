package com.cheng.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class AgriculturalTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scheme_id")
    private Scheme scheme;

    private String stage;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private Double waterUsage;
    private Double nitrogenUsage;
    private Double phosphorusUsage;
    private Double potassiumUsage;
    private String taskName;
    private java.sql.Date taskDate;
    private String condition;
}
