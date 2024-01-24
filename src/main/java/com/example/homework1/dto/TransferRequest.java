package com.example.homework1.dto;

import lombok.Data;

@Data
public class TransferRequest {
	private Integer from;
    private Integer to;
    private Integer money;
}
