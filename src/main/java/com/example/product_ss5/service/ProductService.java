package com.example.product_ss5.service;

import com.example.product_ss5.model.entity.Product;

import java.util.List;
import java.util.Map;


public interface ProductService {
    List<Product> getProducts();
    Product insertProduct(Product product);
    Product updateProduct(Long id,Product product);
    Product updatePartialProduct(Long id, Map<String, Object> updates);
    Boolean deleteProductById(Long id);
}
