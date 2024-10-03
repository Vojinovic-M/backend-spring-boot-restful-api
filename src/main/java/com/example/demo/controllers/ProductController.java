package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductRepository productRepository;
    private final IProductService productService;

    @GetMapping("get-list")
    public List<Product> getList() {
        return productRepository.findAll();
    }

    @PostMapping("create-product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductModel productModel, BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productModel));
    }

    @DeleteMapping("delete-product")
    public ResponseEntity<?> deleteProduct(Integer id) {
       productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted product with id: " + id);
    }

    @PostMapping("update-product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductModel productModel, BindingResult bindingResult) {
        return ResponseEntity.ok(productService.updateProduct(productModel));
    }

}
