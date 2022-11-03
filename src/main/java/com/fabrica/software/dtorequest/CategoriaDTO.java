package com.fabrica.software.dtorequest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fabrica.software.entities.Produto;

public class CategoriaDTO implements Serializable{
		
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private Set<Produto> produtos = new HashSet<>();

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Produto> getProdutos() {
		return produtos;
	}

	

	
	

}
