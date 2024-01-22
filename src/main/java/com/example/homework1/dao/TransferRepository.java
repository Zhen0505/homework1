package com.example.homework1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.homework1.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

	Transfer findByIdAndPassword(Integer id,String password);
	
	@Query(value = "UPDATE account SET balance  = balance  - :money WHERE id = :id", nativeQuery = true)
	void decreaseMoney(@Param("money") Integer money, @Param("id") Integer id);

	@Query(value = "UPDATE account SET balance  = balance  + :money WHERE id = :id", nativeQuery = true)
	void addMoney(@Param("money") Integer money, @Param("id") Integer id);
	
	
}
