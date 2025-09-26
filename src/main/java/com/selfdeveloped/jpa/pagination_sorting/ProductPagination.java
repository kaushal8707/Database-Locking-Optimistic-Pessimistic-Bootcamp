package com.selfdeveloped.jpa.pagination_sorting;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "PRODUCT_PAGINATION_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPagination {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int quantity;
    private long price;
    
    public ProductPagination(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
