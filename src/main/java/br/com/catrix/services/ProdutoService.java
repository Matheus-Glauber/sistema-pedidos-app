package br.com.catrix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Produto;
import br.com.catrix.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id).get();
	}

}
