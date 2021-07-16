package com.example.mapstructdemo.model.destination;

public record PersonDto(
    String firstName,
    String lastName,
    AddressDto address
) {

}
