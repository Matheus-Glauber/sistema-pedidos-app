package br.com.catrix.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.dto.AdicionarClienteDTO;
import br.com.catrix.dto.ClienteDTO;
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
	public ResponseEntity<List<ClienteDTO>> buscarTodosOsClientes() {
		List<Cliente> listaClientes = clienteService.buscarTodos();
		List<ClienteDTO> listaRetorno = listaClientes.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaRetorno);
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
	public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		ClienteDTO clienteRetorno = new ClienteDTO(cliente);
		return new ResponseEntity<>(clienteRetorno, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> adicionarCliente(@RequestBody AdicionarClienteDTO clienteDto) {
		Cliente cliente = clienteService.fromDTO(clienteDto);
		clienteService.salvarCliente(cliente);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value = "/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> atualizarCliente(@RequestBody AdicionarClienteDTO clienteDTO, @PathVariable Long id) {
		if(clienteDTO.getId() == null) {
			clienteDTO.setId(id);
		}
		Cliente cliente = clienteService.fromDTO(clienteDTO);
		clienteService.atualizarCliente(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
		clienteService.excluirCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ClienteDTO>> buscarPaginado(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<Cliente> listaClientes = clienteService.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> clientesPage = listaClientes.map(cliente -> new ClienteDTO(cliente));
		return ResponseEntity.ok().body(clientesPage);		
	}
}
