package com.example.mapstructdemo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.mapstructdemo.model.source.Address;
import com.example.mapstructdemo.model.source.Car;
import com.example.mapstructdemo.model.source.CarType;
import com.example.mapstructdemo.model.source.Driver;
import com.example.mapstructdemo.model.source.Engine;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


class CarToCarDtoMapperTest {

  CarToCarDtoMapper mapper = Mappers.getMapper(CarToCarDtoMapper.class);

  @Test
  void map() {

    var engine = new Engine("oil", false, 200);
    var address = new Address("Stuttgart", "Hauptstraße", "1a", "72600");
    var driver = new Driver("DriverA", address);
    var car = new Car(driver, "aBc200", CarType.COMPACT, LocalDateTime.now().minusYears(2), engine);

    var answer = mapper.toCatDto(car);

    assertNotNull(answer);
    assertEquals(2, answer.getAge());
    assertEquals("ABC200", answer.getDescription());
    assertEquals("oil", answer.getFuelType());
    assertEquals(CarType.COMPACT.toString(), answer.getCategory());
  }
}