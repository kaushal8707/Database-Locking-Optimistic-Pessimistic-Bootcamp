package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {
    private Customer customer;
}
