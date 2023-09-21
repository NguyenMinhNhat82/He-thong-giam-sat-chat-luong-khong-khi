package com.spring.iot.dto;

import com.spring.iot.entities.Main;
import org.hibernate.dialect.function.MinMaxCaseEveryAnyEmulation;

public class MainDTO {
    private Long id;

    private Float aqi;

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
}
