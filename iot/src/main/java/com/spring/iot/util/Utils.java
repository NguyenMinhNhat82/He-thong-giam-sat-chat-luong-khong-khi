package com.spring.iot.util;

import com.spring.iot.entities.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Station> historyValue = new HashMap<String, Station>() {{
        put("station1", null);
        put("station2",null);
        put("station3", null);
        put("station4", null);
        put("station5", null);
    }};
    public static ArrayList<Station> historyStation1 = new ArrayList<>();
    public static ArrayList<Station> historyStation2 = new ArrayList<>();
    public static ArrayList<Station> historyStation3 = new ArrayList<>();
    public static ArrayList<Station> historyStation4 = new ArrayList<>();
    public static ArrayList<Station> historyStation5 = new ArrayList<>();

    public static ArrayList<Station> Station1 = new ArrayList<>();
    public static ArrayList<Station> Station2 = new ArrayList<>();
    public static ArrayList<Station> Station3 = new ArrayList<>();
    public static ArrayList<Station> Station4 = new ArrayList<>();
    public static ArrayList<Station> Station5 = new ArrayList<>();
    public static Map<String,Float> MinCO = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxCO = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinNO = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxNO = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinNO2 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxNO2 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinO3 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxO3 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinSO2 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxSO2 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinPM25 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxPM25 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinPM10 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxPM10 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String,Float> MinNH3 = new HashMap<>(){{
        put("station1", 0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
    public static Map<String, Float> MaxNH3 = new HashMap<>(){{
        put("station1",0f);
        put("station2", 0f);
        put("station3", 0f);
        put("station4", 0f);
        put("station5", 0f);
    }};;
}
