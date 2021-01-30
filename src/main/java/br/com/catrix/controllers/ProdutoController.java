package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Produto;
import br.com.catrix.services.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation(value = "Retorna uma lista de produtos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de produtos"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Produto>> listar() {	
		List<Produto> listaProduto = produtoService.buscarTodosProdutos();
		return ResponseEntity.ok().body(listaProduto);
	}
	
	@ApiOperation(value = "Retorna um produto, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o produto"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		
		Produto produtoRetorno = produtoService.buscarProdutoPorId(id);
		return ResponseEntity.ok().body(produtoRetorno);
			
	}

}
