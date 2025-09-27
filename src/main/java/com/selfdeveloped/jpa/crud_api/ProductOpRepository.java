package com.selfdeveloped.jpa.crud_api;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductOpRepository extends JpaRepository<ProductOp, Integer> {

    List<ProductOp> findByName(String name);
}
