package com.ra.baitapsession18_orm.service;

import com.ra.baitapsession18_orm.dto.ProductDto;
import com.ra.baitapsession18_orm.entity.Product;

import java.util.List;

public interface IProductService
{
    List<Product> findAll();

    ProductDto findById(int id);

    boolean save(ProductDto productDto);

    boolean delete(Integer id);
}
