package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Cliente;
import br.com.catrix.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@ApiOperation(value = "Retorna uma lista de Clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de clientes"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Cliente>> buscarTodosOsClientes() {
		List<Cliente> listaClientes = clienteService.buscarTodos();
		return ResponseEntity.ok().body(listaClientes);
	}
	
	@ApiOperation(value = "Retorna um Cliente, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um Cliente"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}

}
