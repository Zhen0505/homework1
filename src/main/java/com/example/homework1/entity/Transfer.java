package com.example.homework1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}
