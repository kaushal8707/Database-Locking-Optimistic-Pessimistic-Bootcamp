package com.selfdeveloped.jpa.hibernate_n_plus_1_problem_and_solution;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Customer3Repository extends JpaRepository<Customer3, Long> {

    @EntityGraph(attributePaths = "addresses")
    List<Customer3> findAll();

    @Query(" SELECT c FROM Customer3 c LEFT JOIN FETCH c.addresses ")
    List<Customer3> fetchCustomersWithAddresses();
}