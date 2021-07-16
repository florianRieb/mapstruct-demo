package com.example.mapstructdemo.model.destination;

public class CarDto {

  private String description;
  private String fuelType;
  private Integer age;
  private String category;


  public CarDto(String description, String fuelType, Integer age, String category) {
    this.description = description;
    this.fuelType = fuelType;
    this.age = age;
    this.category = category;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public String getFuelType() {
    return fuelType;
  }

  public Integer getAge() {
    return age;
  }

  public String getCategory() {
    return category;
  }
}
