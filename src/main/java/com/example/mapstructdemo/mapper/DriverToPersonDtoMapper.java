package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.model.destination.PersonDto;
import com.example.mapstructdemo.model.source.Driver;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
    DriverAttributeTranslator.class,
    AddressToAddressDtoMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DriverToPersonDtoMapper {

  // mapping method selection via qualifier
  @Mapping(target = "firstName", source = "name", qualifiedBy = DriverAttributeTranslator.FirstName.class)
  @Mapping(target = "lastName", source = "name", qualifiedBy = DriverAttributeTranslator.LastName.class)
  PersonDto toPersonDto(Driver src);

}
