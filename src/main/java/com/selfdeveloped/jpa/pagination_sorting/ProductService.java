package com.selfdeveloped.jpa.pagination_sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

   @Autowired
   private ProductPaginationRepository productPaginationRepository;

   /** one time execution
    * prepared 200 products in db, so commented post-construct annotation
    * */

   //@PostConstruct
   public void initDB() {
       List<ProductPagination> products = IntStream.rangeClosed(1, 200)
               .mapToObj(i -> new ProductPagination("Product_" + i, new Random().nextInt(100), new Random().nextInt(50000)))
               .collect(Collectors.toList());
       productPaginationRepository.saveAll(products);
   }

    public List<ProductPagination> findAllProducts() {
        return productPaginationRepository.findAll();
    }

    public List<ProductPagination> findProductsWithSorting(String field){
        return productPaginationRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    public Page<ProductPagination> findProductsWithPagination(int offset, int pageSize) {
        return productPaginationRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<ProductPagination> findProductsWithPaginationandSorting(int offset, int pageSize,String field) {
        return productPaginationRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }
}
