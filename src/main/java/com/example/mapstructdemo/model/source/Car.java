package com.example.mapstructdemo.model.source;

import java.time.LocalDateTime;

public record Car(
    Driver driver,
    String model,
    CarType type,
    LocalDateTime manufactureDate,
    Engine engine
) {

}
