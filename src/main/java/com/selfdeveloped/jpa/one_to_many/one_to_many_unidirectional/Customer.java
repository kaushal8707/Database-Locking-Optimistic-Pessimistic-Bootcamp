package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String name;
    private String email;
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)   // optional - targetEntity = Product.class
    @JoinColumn(name = "cp_fk" , referencedColumnName = "cid")
    private List<Product> products;
}