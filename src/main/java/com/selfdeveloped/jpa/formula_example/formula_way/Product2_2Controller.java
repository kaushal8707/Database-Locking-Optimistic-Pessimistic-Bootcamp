package com.selfdeveloped.jpa.formula_example.formula_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v2/formula/products")
public class Product2_2Controller {

    @Autowired
    private Product2_2Service productService;

    @PostMapping
    public List<Product2_2> addProducts(@RequestBody List<Product2_2> products) {
        return productService.saveProducts(products);
    }

    @GetMapping
    public List<Product2_2> getAllProducts() {
        return productService.getAllProducts();
    }
}