package com.fabrica.software.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fabrica.software.entities.Categoria;
import com.fabrica.software.repositories.CategoriaRepository;
import com.fabrica.software.services.exceptions.DatabaseException;
import com.fabrica.software.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {
	
	
	private final CategoriaRepository repository;
	
	@Autowired
	public CategoriaService(CategoriaRepository repository) {
		this.repository=repository;
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj= repository.findById(id);
		return obj.get();
	}
	
	public Categoria insert(Categoria obj) {
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
	
	public Categoria atualizar(Long id, Categoria obj) {
		Categoria entidade= repository.getReferenceById(id);
		updateDadoCategoria(entidade, obj);
		return repository.save(entidade);
	}

	private void updateDadoCategoria(Categoria entidade, Categoria obj) {
		entidade.setId(obj.getId());
		entidade.setNome(obj.getNome());
				
	}

}
