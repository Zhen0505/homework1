package com.example.homework1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homework1.dao.TransferRepository;
import com.example.homework1.entity.Transfer;

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
	
	public void decreaseMoney(Integer id,Integer money) {
		Map<String, Object> map=new HashMap<>();
		map.put("id", id);
		map.put("money", money);
		transferR.decreaseMoney(money, id);
	}
	
	public void addMoney(Integer id,Integer money) {
		Map<String, Object> map=new HashMap<>();
		map.put("id", id);
		map.put("money", money);
		transferR.decreaseMoney(money, id);
	}
}
