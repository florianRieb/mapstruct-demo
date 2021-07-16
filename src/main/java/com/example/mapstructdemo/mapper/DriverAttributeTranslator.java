package com.example.mapstructdemo.mapper;

import static org.apache.commons.lang3.StringUtils.strip;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;


@Mapper(componentModel = "spring")
public interface DriverAttributeTranslator {


  @FirstName
  default String firstName(String source) {
    return strip(substringBefore(source, ","));
  }

  @LastName
  default String lastName(String source) {
    var returnStr = strip(substringAfter(source, ","));
    return StringUtils.isEmpty(returnStr) ? null : returnStr;
  }


  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface FirstName {

  }

  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface LastName {

  }

}
