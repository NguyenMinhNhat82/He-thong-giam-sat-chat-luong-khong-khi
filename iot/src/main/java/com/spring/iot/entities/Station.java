package com.spring.iot.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "station")
@Data
public class Station {
    @Id
    private String id;

    private String dt;

//    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component components;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_id", referencedColumnName = "id")
    private Main main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }

    public Component getComponent() {
        return components;
    }

    public void setComponent(Component component) {
        this.components = component;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
