package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QPageRequest;
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

	public Categoria atualizarCategoria(Categoria categoria) {
		buscar(categoria.getId());
		return categoriaRepository.save(categoria);
	}

	public void deletarCategoria(Long id) {
		buscar(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new NegocioNotFoundException(
					"Não é possível excluir uma categoria que possua produtos relacionados.");
		}
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}

}
