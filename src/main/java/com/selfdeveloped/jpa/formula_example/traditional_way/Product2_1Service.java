package com.selfdeveloped.jpa.formula_example.traditional_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Product2_1Service {

    @Autowired
    private Product2_1Repository productRepository;

    public List<Product2_1> saveProducts(List<Product2_1> products) {
        return productRepository.saveAll(products);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseMapper::map)
                .collect(Collectors.toList());
    }
}