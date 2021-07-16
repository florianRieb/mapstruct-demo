package com.example.mapstructdemo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

class DriverAttributeTranslatorTest {

  DriverAttributeTranslator mapper = Mappers.getMapper(DriverAttributeTranslator.class);

  @ParameterizedTest(name = "{index}: {0} => {1}")
  @CsvSource(value = {
      "John, Doe; John",
      "John; John",
      ";"
  }, delimiterString = ";")
  void mapFirstNameTest(String name, String expectedFirstName) {

    // When
    var answer = mapper.firstName(name);

    // Then
    assertEquals(expectedFirstName,answer);

  }

  @ParameterizedTest(name = "{index}: {0} => {1}")
  @CsvSource(value = {
      "John, Doe; Doe",
      "John; ",
      ";"
  }, delimiterString = ";")
  void mapLastNameTest(String name, String expectedLastName) {

    // When
    var answer = mapper.lastName(name);

    // Then
    assertEquals(expectedLastName,answer);

  }
}