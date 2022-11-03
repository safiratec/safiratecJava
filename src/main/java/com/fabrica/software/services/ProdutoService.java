package com.fabrica.software.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fabrica.software.entities.Produto;
import com.fabrica.software.repositories.ProdutoRepository;
import com.fabrica.software.services.exceptions.DatabaseException;
import com.fabrica.software.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	
	private final ProdutoRepository repository;
	
	@Autowired
	public ProdutoService(ProdutoRepository repository) {
		this.repository=repository;
	}
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj= repository.findById(id);
		return obj.get();
	}
	
	public Produto insert(Produto obj) {
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
	
	public Produto atualizar(Long id, Produto obj) {
		Produto entidade= repository.getReferenceById(id);
		updateDadoProduto(entidade, obj);
		return repository.save(entidade);
	}

	private void updateDadoProduto(Produto entidade, Produto obj) {
		entidade.setDescricao(obj.getDescricao());
		entidade.setId(obj.getId());
		entidade.setImgUrl(obj.getImgUrl());
		entidade.setName(obj.getName());
		entidade.setPreco(obj.getPreco());		
				
	}

}
