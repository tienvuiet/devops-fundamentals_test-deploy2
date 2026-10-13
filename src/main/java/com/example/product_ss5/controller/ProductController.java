package com.example.product_ss5.controller;


import com.example.product_ss5.model.dto.response.ApiDataResponse;
import com.example.product_ss5.model.entity.Product;
import com.example.product_ss5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // lay danh sach
    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Product>>> getProducts(){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Get a list of successful products",
                        productService.getProducts(),
                        HttpStatus.OK
                ), HttpStatus.OK
        );
    }
    // them moi
    @PostMapping
    public ResponseEntity<ApiDataResponse<Product>> insertProduct(
            @RequestBody Product product
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "product add successfull",
                        productService.insertProduct(product),
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED
        );
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> updateProduct(
            @PathVariable Long id,
            @RequestBody  Product product
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Product update successfull",
                        productService.updateProduct(id, product),
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> updatePartialProduct(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates
            ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Product partial update success ",
                        productService.updatePartialProduct(id, updates),
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Boolean>> deleteProduct(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Product delete successfull",
                        productService.deleteProductById(id),
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }
}
