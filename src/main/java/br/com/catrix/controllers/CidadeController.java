package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Cidade;
import br.com.catrix.services.CidadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {
	
	@Autowired
	CidadeService cidadeService;
	
	@ApiOperation(value = "Retorna uma lista das Cidades")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista das Cidades"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cidade>> buscarTodos() {
		List<Cidade> ecidadesRetorno = cidadeService.buscaCidades();
		return ResponseEntity.ok(ecidadesRetorno);
	}
	
	@ApiOperation(value = "Retorna uma Cidade, definida pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma Cidade"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
		Cidade cidade = cidadeService.busCidadePorId(id);
		return ResponseEntity.ok(cidade);
	}

}
