package com.selfdeveloped.jpa.formula_example.traditional_way;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String category;
    private double price;
    private double discountPercentage;
    private double priceAfterDiscount;
}