package com.example.demo.services;

import com.example.demo.exceptions.user.UserException;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;


    @Override
    public ProductModel createProduct(ProductModel productModel) {
        var res = ProductMapper.toEntity(productModel);
        var result = productRepository.save(res);
        return ProductMapper.toModel(result);
    }

    @Override
    public void deleteProduct(Integer id) {
        var res = productRepository.findById(id).orElseThrow(() -> new ArithmeticException("User Not Found"));;
        productRepository.delete(res);
    }

    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        var res = ProductMapper.toEntity(productModel);
        try {
            var result = productRepository.save(res);
            return ProductMapper.toModel(result);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
