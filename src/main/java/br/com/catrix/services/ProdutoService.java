package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Produto;
import br.com.catrix.repositories.ProdutoRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto buscarProdutoPorId(Long id) throws NegocioNotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new NegocioNotFoundException("Produto não encontrado, Id: " + id));
	}

}
