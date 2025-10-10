package com.selfdeveloped.jpa.query_hints;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface Employee3Repository extends JpaRepository<Employee3, Long> {

    @Query("SELECT e FROM Employee3 e WHERE e.salary > :salary")
    @QueryHints({
            @QueryHint(name = "org.hibernate.readOnly", value = "true"),
            @QueryHint(name = "org.hibernate.fetchSize", value = "50"),
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"),
            @QueryHint(name = "jakarta.persistence.query.timeout", value = "2000")
    })
    List<Employee3> findEmployeesWithSalaryGreaterThan(@Param("salary") Double salary);
}
