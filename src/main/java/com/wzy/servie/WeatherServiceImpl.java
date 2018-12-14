package com.wzy.servie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzy.entity.Weather;

import java.io.IOException;
import java.util.Map;

public class WeatherServiceImpl implements WeatherService {

    /**
     * 查询天气
     *
     * @param info
     * @return
     */
    public Weather queryWeather(String info) {
        Weather weather = new Weather();
        try {
            if (info != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                //反序列化操作
                Map map = objectMapper.readValue(info, Map.class);
                Map<String, String> weamap = (Map<String, String>) map.get("weatherinfo");
                weather.setCity(weamap.get("city"));
                weather.setTemp(weamap.get("temp"));
                weather.setSd(weamap.get("SD"));
                weather.setDesc("0".equals(weamap.get("rain")) ? "晴" : "有雨");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
