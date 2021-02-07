package br.com.catrix.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.catrix.dto.CategoriaDTO;
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
	public ResponseEntity<List<CategoriaDTO>> listar() {	
		List<Categoria> listaCategoria = categoriaService.buscarTodos();
		List<CategoriaDTO> listaDto = listaCategoria.stream().map(cat -> new CategoriaDTO(cat)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
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
	public ResponseEntity<Void> inserirCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaService.fromDTO(categoriaDTO);
		categoria = categoriaService.inserirCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> atualizarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) {
		Categoria categoria = categoriaService.fromDTO(categoriaDTO, id);
		categoria = categoriaService.atualizarCategoria(categoria);
		
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Deleta uma cateogira")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
		categoriaService.deletarCategoria(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Page<CategoriaDTO>> buscarPaginado(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {	
		Page<Categoria> listaCategoria = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listaDto = listaCategoria.map(cat -> new CategoriaDTO(cat));
		return ResponseEntity.ok().body(listaDto);
	}

}
