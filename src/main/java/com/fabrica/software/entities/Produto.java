package com.fabrica.software.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produto_id")
	private Long id;
	
	@Column(name = "produto_nome", nullable=false)
	private String name;
	
	@Column(name = "produto_descricao")
	private String descricao;
	
	@Column(name = "produto_preco", nullable=false)
	private double preco;
	
	@Column(name = "produto_imagem")
	private String imgUrl;
	
	
	@Column(name = "produto_estoque", nullable=false)
	private int estoque;
	
	//Set garante que um produto tenha apenas uma ocorrência de categoria
	@ManyToMany
	@JoinTable(name= "tb_produto_categoria", joinColumns = @JoinColumn(name="produto_id"), inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private Set<Categoria> categorias= new HashSet<>();
	
	@OneToMany(mappedBy = "id.produto")	
	private Set<ItensPedido> items= new HashSet<>();
	
	public Produto() {
		
	}

	public Produto(Long id, String name, String descricao, double preco, String imgUrl, int estoque) {
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
	
	@JsonIgnore
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
}
