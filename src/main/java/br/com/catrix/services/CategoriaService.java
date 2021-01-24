package br.com.catrix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Categoria;
import br.com.catrix.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Long id) {
		Categoria cat = categoriaRepository.findById(id).get();
		return cat;
	}
	
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

}
