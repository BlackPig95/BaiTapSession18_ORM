package com.ra.baitapsession18_orm.dto;

import com.ra.baitapsession18_orm.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto
{
    private Integer id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @Min(value = 0, message = "Price must be greater than 0")
    @NotNull
    private Double price;
    @Min(value = 0, message = "Stock can't be negative")
    @NotNull
    private Integer stock;
    @NotNull
    private Boolean status;
    @NotNull
    private Integer categoryId;
}