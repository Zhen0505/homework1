package com.example.homework1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homework1.entity.Transfer;
import com.example.homework1.service.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransferService transferS;
	
	@GetMapping("/getlist")
	public List<Transfer> geTransfers(){
		return transferS.geTransfers();
	}
	
	@PostMapping("/register")
	public Transfer register(@RequestBody Transfer rg) {
		return transferS.register(rg);
	}
	
	@PostMapping("/login")
	public Transfer login(@RequestBody Transfer rg) {
		return transferS.login(rg);
	}
	

}
