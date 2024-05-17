package com.ra.baitapsession18_orm.service.impl;

import com.ra.baitapsession18_orm.dao.ICategoryDao;
import com.ra.baitapsession18_orm.dao.IProductDao;
import com.ra.baitapsession18_orm.dao.impl.CategoryDao;
import com.ra.baitapsession18_orm.dao.impl.ProductDao;
import com.ra.baitapsession18_orm.dto.ProductDto;
import com.ra.baitapsession18_orm.entity.Product;
import com.ra.baitapsession18_orm.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService
{
    private final IProductDao productDao;
    private final ICategoryDao categoryDao;

    public ProductService(IProductDao productDao, ICategoryDao categoryDao)
    {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Product> findAll()
    {
        return productDao.findAll();
    }

    @Override
    public ProductDto findById(int id)
    {
        Product product = productDao.findById(id);
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setStatus(product.getStatus());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    @Override
    public boolean save(ProductDto productDto)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setStatus(productDto.getStatus());
        product.setCategory(categoryDao.findById(productDto.getCategoryId()));
        return productDao.save(product);
    }

    @Override
    public boolean delete(Integer id)
    {
        return productDao.delete(id);
    }
}
