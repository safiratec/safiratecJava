package com.fabrica.software.dtorequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fabrica.software.entities.Pedido;
import com.fabrica.software.entities.enums.UserAcess;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String password;
	
	private Integer userAcess;
	
	
	private List<Pedido> pedidos = new ArrayList<>();

	public UsuarioDTO() {

	}

	public UsuarioDTO(Long id, String nome, String email, String password, UserAcess userAcess) {
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

}
