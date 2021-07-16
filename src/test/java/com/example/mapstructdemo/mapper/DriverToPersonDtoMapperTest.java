package com.example.mapstructdemo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.mapstructdemo.model.destination.AddressDto;
import com.example.mapstructdemo.model.source.Address;
import com.example.mapstructdemo.model.source.Driver;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DriverToPersonDtoMapperTest {

  @InjectMocks
  DriverToPersonDtoMapperImpl mapper;

  @Mock
  AddressToAddressDtoMapperImpl toAddressDtoMapper;

  @Mock
  DriverAttributeTranslatorImpl attributeTranslator;

  @Test
  void map() {
    // Given
    var add = new Address("Stuttgart", "Weg", "No1", "2222");
    var driver = new Driver("Ich", add);

    var addressDto = new AddressDto("d", "s", "e");
    var firstname = UUID.randomUUID().toString();
    var lastname = UUID.randomUUID().toString();

    when(toAddressDtoMapper.addressDto(any())).thenReturn(addressDto);
    when(attributeTranslator.firstName(any())).thenReturn(firstname);
    when(attributeTranslator.lastName(any())).thenReturn(lastname);

    // When
    var answer = mapper.toPersonDto(driver);

    // Then
    assertNotNull(answer);
    assertNotNull(answer.address());

    assertEquals(firstname, answer.firstName());
    assertEquals(lastname, answer.lastName());
    assertEquals(addressDto, answer.address());
  }
}