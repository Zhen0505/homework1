package com.example.homework1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homework1.entity.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Integer> {

}
