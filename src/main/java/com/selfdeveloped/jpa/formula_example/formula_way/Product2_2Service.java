package com.selfdeveloped.jpa.formula_example.formula_way;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Product2_2Service {

    @Autowired
    private Product2_2Repository productRepository;

    public List<Product2_2> saveProducts(List<Product2_2> products) {
        return productRepository.saveAll(products);
    }

    public List<Product2_2> getAllProducts() {
        return productRepository.findAll();
    }
}