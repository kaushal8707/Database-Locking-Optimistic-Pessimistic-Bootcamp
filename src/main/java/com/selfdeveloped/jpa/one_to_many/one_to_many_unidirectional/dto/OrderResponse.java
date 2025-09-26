package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse {
    private String name;
	private String productName;

	public OrderResponse(String name, String productName) {
		this.name = name;
		this.productName = productName;
	}
	private int price;
}
