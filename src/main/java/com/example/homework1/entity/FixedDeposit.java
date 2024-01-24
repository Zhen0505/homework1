package com.example.homework1.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "FixedDeposit")
@Entity
public class FixedDeposit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	private Integer amount;  // 定存金额
    private LocalDate startDate; // 定存起始日期
    private Integer durationMonths;  // 定存期限（月数）
	
	@ManyToOne
	@JoinColumn(name = "transfer_fk")
	private Transfer transfer;
}
