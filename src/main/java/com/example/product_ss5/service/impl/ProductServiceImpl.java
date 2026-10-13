package com.example.product_ss5.service.impl;

import com.example.product_ss5.model.entity.Product;
import com.example.product_ss5.repository.ProductRepository;
import com.example.product_ss5.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product ID not found"));
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product updatePartialProduct(Long id, Map<String, Object> updates) {
         Product existingProduct = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product ID not found"));
         if (updates.containsKey("name")){
              existingProduct.setName((String) updates.get("name"));
         }
         if (updates.containsKey("price")){
             existingProduct.setPrice(Double.valueOf(updates.get("price").toString()));
         }
         return productRepository.save(existingProduct);
    }

    @Override
    public Boolean deleteProductById(Long id) {
        productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product ID not found"));
        productRepository.deleteById(id);
        return true;
    }
}
