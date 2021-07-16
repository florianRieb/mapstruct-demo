package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.model.destination.CarDto;
import com.example.mapstructdemo.model.source.Car;
import com.example.mapstructdemo.model.source.Engine;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CarToCarDtoMapper {

  @Mapping(target = "description", source = "model")
  @Mapping(target = "category", source = "type")

  // nested property - except records
  @Mapping(target = "fuelType", source = "engine", qualifiedByName = "fuelType")

  // named custom mapper
  @Mapping(target = "age", source = "manufactureDate", qualifiedByName = "localDateTimeToAge")
  CarDto toCatDto(Car car);

  @Named("localDateTimeToAge")
  default Integer localDateTimeToInt(LocalDateTime source) {
    return Period.between(source.toLocalDate(), LocalDate.now()).getYears();
  }

  @Named("fuelType")
  default String fuelTypeFromEngine(Engine e) {
    return e.fuelType();
  }

  // Only with POJOs not with records
  @AfterMapping
  default void overwriteDesc(Car src, @MappingTarget CarDto dest) {
    dest.setDescription(StringUtils.upperCase(dest.getDescription()));
  }
}
