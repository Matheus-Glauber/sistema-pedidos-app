package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Estado;
import br.com.catrix.services.EstadoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	@ApiOperation(value = "Retorna uma lista dos Estados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista dos Estados"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Estado>> buscarTodos() {
		List<Estado> estadosRetorno = estadoService.buscarTodos();
		return ResponseEntity.ok(estadosRetorno);
	}
	
	@ApiOperation(value = "Retorna um Estado, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o Estado"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Estado> buscarPorId(@PathVariable Long id) {
		Estado estado = estadoService.buscarPorId(id);
		return ResponseEntity.ok(estado);
	}

}
