package com.spring.iot.util;

import com.spring.iot.entities.Station;

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
}
