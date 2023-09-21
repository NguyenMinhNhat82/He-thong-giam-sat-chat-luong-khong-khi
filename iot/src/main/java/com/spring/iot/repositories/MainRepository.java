package com.spring.iot.repositories;

import com.spring.iot.entities.Main;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<Main,Long> {
}
