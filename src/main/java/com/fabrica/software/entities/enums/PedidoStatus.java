package com.fabrica.software.entities.enums;

public enum PedidoStatus {
	
	AGUARDADNDO_PAGAMENTO(0),
	PAGO(1),
	ENVIADO(2),
	TRANSITANDO(3),
	CANCELADO(4);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code=code;
	}
	
	public int getPedidoStatusCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for(PedidoStatus value: PedidoStatus.values()) {
			if(value.getPedidoStatusCode()==code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código inválido do PedidoStatus ");
	}
	
}
