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

import java.util.HashMap;
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
    @GetMapping("/api/datastation/{id}")
    @CrossOrigin
    ResponseEntity <List<Station>> getDataStation (@PathVariable String id){
        if(id.equals("station1"))
            return new ResponseEntity<>(Station1,HttpStatus.OK);
        else
        if(id.equals("station2"))
            return new ResponseEntity<>(Station2,HttpStatus.OK);
        else
        if (id.equals("station3"))
            return new ResponseEntity<>(Station3,HttpStatus.OK);
        else
        if (id.equals("station4"))
            return new ResponseEntity<>(Station4,HttpStatus.OK);
        else
        if (id.equals("station5"))
            return new ResponseEntity<>(Station5,HttpStatus.OK);
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/api/maxCO/{id}")
    @CrossOrigin
    ResponseEntity<Map<String,Float>> maxCO(@PathVariable String id){
        Map<String,Float> res = new HashMap<>();
        res.put("co",MaxCO.get(id));
        res.put("no",MaxNO.get(id));
        res.put("no2",MaxNO2.get(id));
        res.put("o3",MaxO3.get(id));
        res.put("so2",MaxSO2.get(id));
        res.put("pm25",MaxPM25.get(id));
        res.put("pm10",MaxPM10.get(id));
        res.put("nh3",MaxNH3.get(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping("/api/minCO/{id}")
    @CrossOrigin
    ResponseEntity<Map<String,Float>> MinCO(@PathVariable String id){
        Map<String,Float> res = new HashMap<>();
        res.put("co",MinCO.get(id));
        res.put("no",MinNO.get(id));
        res.put("no2",MinNO2.get(id));
        res.put("o3",MinO3.get(id));
        res.put("so2",MinSO2.get(id));
        res.put("pm25",MinPM25.get(id));
        res.put("pm10",MinPM10.get(id));
        res.put("nh3",MinNH3.get(id));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/api/all-staion")
    @CrossOrigin
    ResponseEntity<List<Station>> getAllStation(){
        return new ResponseEntity<>(stationService.getAllStation(),HttpStatus.OK);
    }

    @GetMapping("/api/current/{id}")
    @CrossOrigin
    ResponseEntity<Station> currentStatusStation(@PathVariable String id){
        return  new ResponseEntity<>(stationService.findStattionByID(id),HttpStatus.OK);
    }

}
