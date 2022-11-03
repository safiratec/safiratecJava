package com.fabrica.software.dtorequest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fabrica.software.entities.Categoria;
import com.fabrica.software.entities.ItensPedido;
import com.fabrica.software.entities.Pedido;

public class ProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String descricao;
	private double preco;
	private String imgUrl;
	private int estoque;
	
	//Set garante que um produto tenha apenas uma ocorrência de categoria	
	private Set<Categoria> categorias= new HashSet<>();
	
	
	private Set<ItensPedido> items= new HashSet<>();
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(Long id, String name, String descricao, double preco, String imgUrl, int estoque) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	
	public Set<Pedido> getPedido(){
		Set<Pedido> set= new HashSet<>();
		for(ItensPedido x: items) {
			set.add(x.getPedido());
		}
		return set;
	}

	public int getQuantidade() {
		return estoque;
	}

	public void setQuantidade(int estoque) {
		this.estoque = estoque;
	}

}
