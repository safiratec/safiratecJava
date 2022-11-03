package com.fabrica.software.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.fabrica.software.entities.Usuario;
import com.fabrica.software.repositories.UsuarioRepository;
import com.fabrica.software.services.exceptions.DatabaseException;
import com.fabrica.software.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	
	private final UsuarioRepository repository;
	
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository=repository;
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Usuario atualizar(Long id, Usuario obj) {
		try {
			Usuario entidade = repository.getReferenceById(id);
			updateDadoUsuario(entidade, obj);
			return repository.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDadoUsuario(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());

	}

}
