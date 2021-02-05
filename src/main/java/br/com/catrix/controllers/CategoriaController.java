package br.com.catrix.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.catrix.entities.Categoria;
import br.com.catrix.services.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation(value = "Retorna uma lista de categorias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de categorias"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Categoria>> listar() {	
		List<Categoria> listaCategoria = categoriaService.buscarTodos();
		return ResponseEntity.ok().body(listaCategoria);
	}
	
	@ApiOperation(value = "Retorna uma categoria, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a categoria"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
		
		Categoria categoriaRetorno  = categoriaService.buscar(id);
		return ResponseEntity.ok().body(categoriaRetorno);
		
	}
	
	@ApiOperation(value = "Cria uma cateogira")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Criado com sucesso"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Void> inserirCategoria(@RequestBody Categoria categoria) {
		categoria = categoriaService.inserirCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
		categoria = categoriaService.atualizarCategoria(categoria);
		
		return ResponseEntity.noContent().build();
	}

}
