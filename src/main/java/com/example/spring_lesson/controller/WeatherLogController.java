package com.example.spring_lesson.controller;

import com.example.spring_lesson.service.WeatherReceiveService;
import com.example.spring_lesson.service.impl.WeatherLogServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherLogController {
    private final WeatherLogServiceImpl weatherLogServiceImpl;

    @Operation(summary = "Weather api main log page")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "main log page",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) })}
    )
    @GetMapping("/weather_log/")
    public ResponseEntity<String> showWeather(){
        return new ResponseEntity<>("Добавьце в адресную строку название города. Можно кирилицей", HttpStatus.OK);
    }

    @Operation(summary = "Weather city log")
    @ApiOperation(authorizations = {@Authorization(value = "basicAuth")}, value = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "page with current page",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)) }),
            @ApiResponse(responseCode = "404", description = "Given city not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})}

    )
    @PreAuthorize("hasAnyAuthority('log_perm')")
    @GetMapping("/weather_log/{city}")
    public ResponseEntity<String> showWeather(@PathVariable(name = "city") String city)  {
        return new ResponseEntity<>(weatherLogServiceImpl.getLog(city), HttpStatus.OK);
    }
}
