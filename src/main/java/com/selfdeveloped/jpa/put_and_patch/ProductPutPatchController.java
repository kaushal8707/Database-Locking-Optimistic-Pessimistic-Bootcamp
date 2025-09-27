package com.selfdeveloped.jpa.put_and_patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo/products")
public class ProductPutPatchController {

    @Autowired
    private ProductPutPatchService service;

    @PostMapping
    public ProductPutPatch addProduct(@RequestBody ProductPutPatch product) {
        return service.saveProduct(product);
    }

    @GetMapping
    public List<ProductPutPatch> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductPutPatch getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductPutPatch updateProduct(@PathVariable int id, @RequestBody ProductPutPatch productRequest) {
        return service.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public ProductPutPatch updateProductByField(
            @PathVariable int id,
            @RequestBody Map<String, Object> mappedObject) {
        return service.updateProductByField(id, mappedObject);
    }
}
