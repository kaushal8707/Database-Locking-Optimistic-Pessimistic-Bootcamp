package com.selfdeveloped.jpa.put_and_patch;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductPutPatchService {

    private final ProductPutPatchRepository repository;

    public ProductPutPatchService(ProductPutPatchRepository repository) {
        this.repository = repository;
    }

    public ProductPutPatch saveProduct(ProductPutPatch product) {
        return repository.save(product);
    }

    public List<ProductPutPatch> getAllProducts() {
        return repository.findAll();
    }

    public ProductPutPatch getProductById(int id) {
        return repository.findById(id).get();
    }

    public ProductPutPatch updateProduct(int id, ProductPutPatch productRequest) {
        // get the product from DB by id
        // update with new value getting from request
        ProductPutPatch existingProduct = repository.findById(id)
                .orElseThrow(()-> {
                    throw new RuntimeException("product not found id - "+ id);});
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setProductType(productRequest.getProductType());
        return repository.save(existingProduct);
    }

    public long deleteProduct(int id) {
        repository.deleteById(id);
        return repository.count();
    }

    public ProductPutPatch updateProductByField(int id, Map<String, Object> mappedObject) {
        ProductPutPatch existingProduct = repository.findById(id).orElseGet(() -> {
            throw new RuntimeException("product not found id - " + id);
        });
        mappedObject.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(ProductPutPatch.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingProduct, value);
        });
        return repository.save(existingProduct);
    }
}
