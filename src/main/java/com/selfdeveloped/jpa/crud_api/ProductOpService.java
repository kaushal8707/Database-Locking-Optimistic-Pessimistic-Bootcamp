package com.selfdeveloped.jpa.crud_api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOpService {
    @Autowired
    private ProductOpRepository productRepository;

    public ProductOp saveProduct(ProductOp product) {
        return productRepository.save(product);
    }

    public List<ProductOp> saveProducts(List<ProductOp> products) {
        return productRepository.saveAll(products);
    }

    public List<ProductOp> getProducts(){
        return productRepository.findAll();
    }

    public ProductOp getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<ProductOp> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "product remove || "+id;
    }

    public ProductOp updateProduct(ProductOp product) {
        ProductOp existingProduct=productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }
}
