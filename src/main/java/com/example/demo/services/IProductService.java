package com.example.demo.services;

import com.example.demo.models.ProductModel;

public interface IProductService {

    ProductModel createProduct(ProductModel productModel);
    void deleteProduct(Integer id);
    ProductModel updateProduct(ProductModel productModel);
}
