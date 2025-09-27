package com.selfdeveloped.jpa.crud_api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/operations")
@RestController
public class ProductOpController {

    @Autowired
    private ProductOpService productService;

    @PostMapping("/addProduct")
    public ProductOp addProduct(@RequestBody ProductOp product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<ProductOp> addProducts(@RequestBody List<ProductOp> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<ProductOp> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public ProductOp findProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public List<ProductOp> findProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public ProductOp updateProduct(@RequestBody ProductOp product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
