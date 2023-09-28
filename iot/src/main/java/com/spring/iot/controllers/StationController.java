package com.spring.iot.controllers;


import com.spring.iot.entities.Station;
import com.spring.iot.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

import static com.spring.iot.util.Utils.*;

@Controller
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/data")
    @CrossOrigin
    ResponseEntity<Map<String, Station>> getdata(){
        Map<String, Station> s = historyValue;
        return new ResponseEntity<>(historyValue, HttpStatus.OK);
    }
    @GetMapping("/api/history/{id}")
    @CrossOrigin
    ResponseEntity <List<Station>> getHistoryStation (@PathVariable String id){
        if(id.equals("station1"))
            return new ResponseEntity<>(historyStation1,HttpStatus.OK);
        else
            if(id.equals("station2"))
                return new ResponseEntity<>(historyStation2,HttpStatus.OK);
            else
                if (id.equals("station3"))
                    return new ResponseEntity<>(historyStation3,HttpStatus.OK);
                else
                    if (id.equals("station4"))
                        return new ResponseEntity<>(historyStation4,HttpStatus.OK);
                    else
                        if (id.equals("station5"))
                            return new ResponseEntity<>(historyStation5,HttpStatus.OK);
                        else
                            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/api/maxCO/{id}")
    @CrossOrigin
    ResponseEntity<Float> maxCO(@PathVariable String id){
        if (id.equals("station1"))
            return new ResponseEntity<>(MaxCO1,HttpStatus.OK);
        else
            if (id.equals("station2"))
                return new ResponseEntity<>(MaxCO2,HttpStatus.OK);
            else
            if (id.equals("station3"))
                return new ResponseEntity<>(MaxCO3,HttpStatus.OK);
            else
            if (id.equals("station4"))
                return new ResponseEntity<>(MaxCO4,HttpStatus.OK);
            else
            if (id.equals("station5"))
                return new ResponseEntity<>(MaxCO5,HttpStatus.OK);
            else
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/api/minCO/{id}")
    @CrossOrigin
    ResponseEntity<Float> MinCO(@PathVariable String id){
        if (id.equals("station1"))
            return new ResponseEntity<>(MinCO1,HttpStatus.OK);
        else
        if (id.equals("station2"))
            return new ResponseEntity<>(MinCO2,HttpStatus.OK);
        else
        if (id.equals("station3"))
            return new ResponseEntity<>(MinCO3,HttpStatus.OK);
        else
        if (id.equals("station4"))
            return new ResponseEntity<>(MinCO4,HttpStatus.OK);
        else
        if (id.equals("station5"))
            return new ResponseEntity<>(MinCO5,HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/all-staion")
    @CrossOrigin
    ResponseEntity<List<Station>> getAllStation(){
        return new ResponseEntity<>(stationService.getAllStation(),HttpStatus.OK);
    }

}
