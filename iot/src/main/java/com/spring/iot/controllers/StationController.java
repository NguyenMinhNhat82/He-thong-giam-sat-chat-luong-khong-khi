package com.spring.iot.controllers;


import com.spring.iot.entities.Station;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static com.spring.iot.util.Utils.historyValue;

@Controller
public class StationController {

    @GetMapping("/api/data")
    @CrossOrigin
    ResponseEntity<Map<String, Station>> getdata(){
        Map<String, Station> s = historyValue;
        return new ResponseEntity<>(historyValue, HttpStatus.OK);
    }
}
