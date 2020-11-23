package com.example.spring_lesson.service.impl;

import com.example.spring_lesson.model.City;
import com.example.spring_lesson.model.WeatherConditions;
import com.example.spring_lesson.model.WeatherState;
import com.example.spring_lesson.service.WeatherLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherLogServiceImpl implements WeatherLogService {
    private final CityServiceImpl cityService;
    private final WeatherConditionsServiceImpl weatherConditionService;
    private final WeatherStateServiceImpl weatherStateService;

    @Override
    public String getLog(String cityName) {
        City city = cityService.findByName(cityName);
        if (city == null)
            return "Нет данных";
        List<WeatherState> states = weatherStateService.getByCityId(city.getId());
        String todayWeather = "Сегодня в городе %s :";
        String res = String.format(todayWeather, city.getName());
        for (WeatherState state : states)
        {
            for (Integer code : state.getCondition())
            {
                code = code / 100  * 100;
                WeatherConditions conditionEntity = weatherConditionService.getByCode(code);
                String description = String.format("в %s часов %s %s градусов", state.getRequestTime(),
                        conditionEntity.getValue(), state.getTemperature());
                res += (description + "\\n") ;
            }
        }
        return res;
    }

}
