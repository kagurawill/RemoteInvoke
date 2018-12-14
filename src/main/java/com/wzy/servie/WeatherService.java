package com.wzy.servie;

import com.wzy.entity.Weather;

public interface WeatherService {
    /**
     * 查询天气的接口
     * @param cityCode
     * @return
     */
    Weather queryWeather(String cityCode);
}