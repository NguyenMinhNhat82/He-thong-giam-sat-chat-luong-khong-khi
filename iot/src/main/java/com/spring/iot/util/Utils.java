package com.spring.iot.util;

import com.spring.iot.entities.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, Station> historyValue = new HashMap<String, Station>() {{
        put("station1", null);
        put("station2", null);
        put("station3", null);
        put("station4", null);
        put("station5", null);
    }};
    public static ArrayList<Station> historyStation1 = new ArrayList<>();
    public static ArrayList<Station> historyStation2 = new ArrayList<>();
    public static ArrayList<Station> historyStation3 = new ArrayList<>();
    public static ArrayList<Station> historyStation4 = new ArrayList<>();
    public static ArrayList<Station> historyStation5 = new ArrayList<>();
    public static  Float MinCO1 = 5000.0f , MaxCO1 = 0.0f ;
    public static  Float MinCO2 = 5000.0f , MaxCO2 = 0.0f ;
    public static  Float MinCO3 = 5000.0f , MaxCO3 = 0.0f ;
    public static  Float MinCO4 = 5000.0f , MaxCO4 = 0.0f ;
    public static  Float MinCO5 = 5000.0f , MaxCO5 = 0.0f ;
}
