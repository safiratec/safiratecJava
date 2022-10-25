package com.fabrica.software.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fabrica.software.entities.Pedido;
import com.fabrica.software.repositories.PedidoRepository;
import com.fabrica.software.services.exceptions.DatabaseException;
import com.fabrica.software.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj= repository.findById(id);
		return obj.get();
	}
	
	public Pedido insert(Pedido obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public Pedido atualizar(Long id, Pedido obj) {
		Pedido entidade= repository.getReferenceById(id);
		updateDadoPedido(entidade, obj);
		return repository.save(entidade);
	}

	private void updateDadoPedido(Pedido entidade, Pedido obj) {
		entidade.setId(obj.getId());
		entidade.setMomento(obj.getMomento());
		entidade.setPagamento(obj.getPagamento());
		entidade.setPedidoStatus(obj.getPedidoStatus());
		entidade.setUsuario(obj.getUsuario()); 
				
				
	}

}
