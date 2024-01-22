package com.example.homework1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.homework1.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {

	Transfer findByIdAndPassword(Integer id,String password);
	
	@Modifying
	@Query(value = "UPDATE TEST  SET BALANCE  = BALANCE  - :money WHERE ID = :id", nativeQuery = true)
	void decreaseMoney(@Param("id") Integer id,@Param("money") Integer money);

	@Modifying
	@Query(value = "UPDATE TEST  SET BALANCE  = BALANCE  + :money WHERE ID = :id", nativeQuery = true)
	void addMoney(@Param("id") Integer id,@Param("money") Integer money);
	
	
}
