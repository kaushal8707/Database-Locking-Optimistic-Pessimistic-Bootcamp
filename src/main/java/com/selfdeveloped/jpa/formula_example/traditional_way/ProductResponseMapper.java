package com.selfdeveloped.jpa.formula_example.traditional_way;

public class ProductResponseMapper {
    public static ProductResponse map(Product2_1 product){

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .discountPercentage(product.getDiscountPercentage())
                .priceAfterDiscount(product.getPrice() - (product.getPrice() * product.getDiscountPercentage()/100))
                .build();
    }
}
