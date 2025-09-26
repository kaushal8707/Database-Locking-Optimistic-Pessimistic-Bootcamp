package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
