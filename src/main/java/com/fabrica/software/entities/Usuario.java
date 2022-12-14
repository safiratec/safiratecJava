package com.fabrica.software.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fabrica.software.entities.enums.UserAcess;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	
	@Column(name = "usuario_nome", nullable=false, unique=true)	
	private String nome;
	
	@Column(name = "usuario_email", nullable=false, unique=true)
	private String email;
	
	@Column(name = "usuario_password", nullable=false)
	private String password;
	
	@Column(name = "usuario_acesso", nullable=false)
	private Integer userAcess;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(Long id, String nome, String email, String password, UserAcess userAcess) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		setUserAcess(userAcess);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public UserAcess getUserAcess() {
		return UserAcess.valueOf(userAcess);
	}

	public void setUserAcess(UserAcess userAcess) {
		if(userAcess!=null) {
			this.userAcess= userAcess.getUserCode();
		}
		else {
			throw new IllegalArgumentException("Null argument");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	

}
