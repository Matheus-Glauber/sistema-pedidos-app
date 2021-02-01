package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Endereco;
import br.com.catrix.services.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@ApiOperation(value = "Retorna uma lista de Clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de clientes"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Endereco>> buscarTodosOsEnderecos() {
		List<Endereco> listaEnderecos = enderecoService.buscarTodosOsEnderecos();
		return new ResponseEntity<>(listaEnderecos, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna um Endereço, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um Endereço"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
		Endereco endereco = enderecoService.buscarEnderecoPorId(id);
		return new ResponseEntity<>(endereco, HttpStatus.OK);
	}

}
