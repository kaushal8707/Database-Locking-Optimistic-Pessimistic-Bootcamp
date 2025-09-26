package com.selfdeveloped.jpa.pagination_sorting;

import com.selfdeveloped.jpa.pagination_sorting.dto.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductPaginationSortingDemoController {

    @Autowired
    private ProductService productService;

    @GetMapping
     APIResponse<List<ProductPagination>> getProducts(){
        List<ProductPagination> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
     APIResponse<List<ProductPagination>> getProductsWithSorting(@PathVariable String field) {
        List<ProductPagination> allProducts = productService.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
     APIResponse<Page<ProductPagination>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<ProductPagination> productsWithPagination = productService.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
     APIResponse<Page<ProductPagination>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<ProductPagination> productsWithPagination = productService.findProductsWithPaginationandSorting(offset, pageSize,field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
}
