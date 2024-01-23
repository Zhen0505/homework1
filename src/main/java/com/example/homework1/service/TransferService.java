package com.example.homework1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homework1.dao.TransferRepository;
import com.example.homework1.entity.Transfer;

import jakarta.transaction.Transactional;

@Service
public class TransferService {

	@Autowired
	private TransferRepository transferR;
	
	public List<Transfer> geTransfers(){
		return transferR.findAll();
	}
	
	public Transfer register(Transfer rg) {
		Integer rid=rg.getId();
		Optional<Transfer> oid=transferR.findById(rid);
		if(oid.isEmpty()) {
			return transferR.save(rg);
		}
		else {
			return null;
		}
	}
	
	public Transfer login(Transfer lg) {
		Integer lid=lg.getId();
		String lpw=lg.getPassword();
		Transfer transfer=transferR.findByIdAndPassword(lid, lpw);
		if(transfer!=null) {
			return transfer;
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public void transfer(Integer fromAccountId,
			Integer toAccountId, Integer money) {

        // User A 扣除轉帳金額
        transferR.decreaseMoney(fromAccountId, money);

        // User B 收到轉入金額
        transferR.addMoney(toAccountId, money);
    }
	
	public String register2(Transfer rg) {
		Integer rid=rg.getId();
		Optional<Transfer> oid=transferR.findById(rid);
		if(oid.isEmpty()) {
			transferR.save(rg);
			return "註冊成功!";
		}
		else {
			return "註冊失敗，帳號已存在";
		}
	}
	
	public String login2(Transfer lg) {
		Integer id=lg.getId();
		String pw=lg.getPassword();
		Transfer transfer=transferR.findByIdAndPassword(id, pw);
		Optional<Transfer> findid=transferR.findById(id);
		if(transfer!=null) {
			String name=transfer.getName();
			return "登入成功!歡迎"+name;
		}
		else if (findid.isEmpty()) {
			return "登入失敗，帳號不存在";
		}
		else {
			return "登入失敗，密碼錯誤";
		}
	}
	
	@Transactional
	public String transfer2(Integer fromAccountId,
			Integer toAccountId, Integer money) {
		
		Optional<Transfer> fromid=transferR.findById(fromAccountId);
		Optional<Transfer> toid=transferR.findById(toAccountId);
		
		if(fromid.isPresent()&&toid.isPresent()) {
			
			Transfer fromAccoount=fromid.get();
			Transfer toAccoount=toid.get();
			
			if(fromAccoount.getId()!=toAccoount.getId())
			{
				if(fromAccoount.getBalance()>=money) {
					
					// Decrease money from fromAccount
					fromAccoount.setBalance(fromAccoount.getBalance()-money);
					transferR.save(fromAccoount);
					
					// Add money to toAccount
					toAccoount.setBalance(toAccoount.getBalance()+money);
					transferR.save(toAccoount);
					
					return"轉帳成功!";
				}
				else {
					return "餘額不足，轉帳失敗";
				}
			}
			else {
				return "轉出及轉入帳號不可相同";
			}
			
		}
		else if (fromid.isEmpty()) {
			return "轉帳失敗，轉出帳號不存在";
		}
		
		else {
			return"轉帳失敗，轉帳號不存在!";
		}
    }
}
