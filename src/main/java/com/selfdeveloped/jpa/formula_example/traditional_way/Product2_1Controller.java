package com.selfdeveloped.jpa.formula_example.traditional_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trd/products")
public class Product2_1Controller {

    @Autowired
    private Product2_1Service productService;

    @PostMapping
    public List<Product2_1> addProducts(@RequestBody List<Product2_1> products) {
        return productService.saveProducts(products);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}