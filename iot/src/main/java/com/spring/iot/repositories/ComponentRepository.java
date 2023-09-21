package com.spring.iot.repositories;

import com.spring.iot.entities.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component,Long> {
}
