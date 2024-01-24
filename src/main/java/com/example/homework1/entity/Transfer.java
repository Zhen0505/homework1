package com.example.homework1.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Test")
@Entity
public class Transfer {
	
	@Id
	Integer id;
	
	String name;
	
	String password;
	
	Integer balance;
	
	Integer fixedD;
	
	Integer total;
	
	@OneToMany(mappedBy = "transfer",cascade = CascadeType.PERSIST)
	private List<FixedDeposit> fixedDeposits;

    // 在从数据库加载实体后计算 total 的方法
//	@PostLoad
//	private void calculateTotal() {
//        this.total = (balance != null ? balance : 0) + (fixedD != null ? fixedD : 0);
//    }
	
	// Calculate total by iterating over FixedDeposit list
	@PostLoad
	public void calculateTotal() {
        int totalAmount = this.balance;

        if (this.fixedDeposits != null) {
            for (FixedDeposit fixedDeposit : this.fixedDeposits) {
                totalAmount += fixedDeposit.getAmount();
            }
        }

        this.total = totalAmount;
    }
}
