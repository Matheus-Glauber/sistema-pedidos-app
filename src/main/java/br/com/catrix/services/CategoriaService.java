package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Categoria;
import br.com.catrix.repositories.CategoriaRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Long id) throws NegocioNotFoundException {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElseThrow(() -> new NegocioNotFoundException("Categoria não encontrada, Id: " + id));
	}
	
	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	public Categoria inserirCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
