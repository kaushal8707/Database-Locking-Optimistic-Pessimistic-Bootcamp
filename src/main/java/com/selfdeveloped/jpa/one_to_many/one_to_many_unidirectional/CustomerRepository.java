package com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.dto.*;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	/** JOIN */
	@Query("select new com.selfdeveloped.jpa.one_to_many.one_to_many_unidirectional.dto.OrderResponse(c.name, p.productName) from Customer c JOIN c.products p")
	List<OrderResponse> getJoinInformation();

	/** JPQL */
	@Query("select c from Customer c where c.email = :email")
	List<Customer> getCustomerByEmail(@Param("email") String email);

	/** Indexed Query */
	@Query("select c from Customer c where c.name = ?1")
	List<Customer> getAllCustomerByNames(@Param("name") String name);

	@Transactional
	@Modifying
	@Query("update Customer c set c.email = :email where c.cid = :cid")
	void updateEmail(@Param("cid") int cid, @Param("email") String email);

	@Transactional
	@Modifying
	@Query("update Customer set email = ?2 where cid = ?1")
	@Lock(LockModeType.NONE)
	void changeEmail(int cid, String email);
	}

