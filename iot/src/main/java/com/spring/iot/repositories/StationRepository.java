package com.spring.iot.repositories;

import com.spring.iot.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station,String> {
    Station findStationById(String id);
}
