package com.example.homework1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homework1.dto.TransferRequest;
import com.example.homework1.entity.FixedDeposit;
import com.example.homework1.entity.Transfer;
import com.example.homework1.service.TransferService;


@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransferService transferS;
	
	@GetMapping(value = "/getlist")
	public List<Transfer> geTransfers(){
		return transferS.geTransfers();
	}
	
	@PostMapping(value = "/register")
	public Transfer register(@RequestBody Transfer rg) {
		return transferS.register(rg);
	}
	
	@PostMapping(value = "/login")
	public Transfer login(@RequestBody Transfer rg) {
		return transferS.login(rg);
	}
	
	@PostMapping(value = "/transfer")
    public String transfer(@RequestBody TransferRequest transferRequest) {

		transferS.transfer(
                transferRequest.getFrom(),
                transferRequest.getTo(),
                transferRequest.getMoney()
        );

        return "轉帳成功!";
    }
	
	@PostMapping(value = "/register2")
	public String register2(@RequestBody Transfer rg) {
		return transferS.register2(rg);
	}
	
	@PostMapping(value = "/login2")
	public String login2(@RequestBody Transfer rg) {
		return transferS.login2(rg);
	}
	
	@PostMapping(value = "/transfer2")
    public String transfer2(@RequestBody TransferRequest transferRequest) {

		String result=transferS.transfer2(
                transferRequest.getFrom(),
                transferRequest.getTo(),
                transferRequest.getMoney()
        );
		
        return result;
    }

	@PostMapping(value = "/fd/{id}")
	public List<FixedDeposit> fddd(@PathVariable Integer id
			,@RequestBody FixedDeposit fd) {
		return transferS.fdd(id, fd);
	}
}
