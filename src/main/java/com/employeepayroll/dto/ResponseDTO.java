package com.employeepayroll.dto;

import lombok.Getter;

@Getter
public class ResponseDTO {

	String message;
	Object obj;
	
	public ResponseDTO(String message, Object obj) {
		this.message = message;
		this.obj = obj;
	}
	
}
