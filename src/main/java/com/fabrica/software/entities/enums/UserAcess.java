package com.fabrica.software.entities.enums;

public enum UserAcess {

	TESTE(1), 
	COMPRADOR(2), 
	VENDEDOR(3);

	private int code;

	private UserAcess(int code) {
		this.code = code;
	}
	
	public int getUserCode() {
		return code;
	}
	
	public static UserAcess valueOf(int code) {
		for(UserAcess value: UserAcess.values()) {
			if(value.getUserCode()==code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido do UserAcess");

	}



}
