package com.example.spring_lesson.model;

public enum Permission {
    WEATHER_GET("weather:get"),
    WEATHER_LOG("weather:log");

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
