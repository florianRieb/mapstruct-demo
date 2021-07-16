package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.model.destination.AddressDto;
import com.example.mapstructdemo.model.source.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressToAddressDtoMapper {

  @Mapping(target = "street", source = "streetName")
  @Mapping(target = "streetNo", constant = "N/A")
    // if source is null
  AddressDto addressDto(Address src);
}
