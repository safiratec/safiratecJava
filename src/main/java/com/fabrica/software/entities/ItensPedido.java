package com.fabrica.software.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fabrica.software.entities.pk.ItemPedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "itens_pedido")
public class ItensPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK id= new ItemPedidoPK();
	
	@Column(name = "quantidade", nullable=false)
	private int quantidade;
	
	@Column(name = "preco_final", nullable=false)
	private double precoFinal;

	public ItensPedido() {

	}

	public ItensPedido(Pedido pedido, Produto produto, int quantidade, double precoFinal) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.precoFinal = precoFinal;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public int getquantidade() {
		return quantidade;
	}

	public void setquantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getprecoFinal() {
		return precoFinal;
	}

	public void setprecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
	}
	
	public Double getTotal() {
		return precoFinal*quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensPedido other = (ItensPedido) obj;
		return Objects.equals(id, other.id);
	}

}
