package com.spring.iot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.iot.dto.MainDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.dialect.function.MinMaxCaseEveryAnyEmulation;

@Entity
@Table(name = "main")
public class Main {
    @Id
    private Long id;

    private Float aqi;


    @JsonIgnore
    @OneToOne(mappedBy = "main")
    private Station station;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAqi() {
        return aqi;
    }

    public void setAqi(Float aqi) {
        this.aqi = aqi;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
