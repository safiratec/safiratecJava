package com.fabrica.software.dtorequest;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fabrica.software.entities.ItensPedido;
import com.fabrica.software.entities.Pagamento;
import com.fabrica.software.entities.Usuario;
import com.fabrica.software.entities.enums.PedidoStatus;

public class PedidoDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	private Long id;

			
	private Instant momento;
	
	
	private Usuario usuario;
	
	
	private Set<ItensPedido> items = new HashSet<>();
	
	private Integer pedidoStatus;
	
	
	
	private Pagamento pagamento;
	
	public PedidoDTO() {
		
	}

	public PedidoDTO(Long id, Instant momento, PedidoStatus pedidoStatus, Usuario usuario) {
		
		this.id = id;
		this.momento = momento;
		setPedidoStatus(pedidoStatus);
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus!=null) {
			this.pedidoStatus = pedidoStatus.getPedidoStatusCode();
		}
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItensPedido> getItems(){
		return items;
	}
	
	

}
