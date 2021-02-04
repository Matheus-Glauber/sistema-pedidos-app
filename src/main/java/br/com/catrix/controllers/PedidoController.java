package br.com.catrix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.entities.Pedido;
import br.com.catrix.services.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@ApiOperation(value = "Retorna uma lista de pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de pedidos"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")			
	})
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Pedido>> listar() {	
		List<Pedido> listaPedido = pedidoService.buscarTodos();
		return ResponseEntity.ok().body(listaPedido);
	}
	
	@ApiOperation(value = "Retorna uma pedido, definido pelo id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a pedido"),
			@ApiResponse(code = 400, message = "Página não encontrada"),
			@ApiResponse(code = 401, message = "Usuário não autenticado"),
			@ApiResponse(code = 403, message = "Usuário sem permissão"),
			@ApiResponse(code = 404, message = "Nada encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")	
	})
	@RequestMapping(method = RequestMethod.GET, value = "/{id}",produces = "application/json")
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
		
		Pedido pedidoRetorno  = pedidoService.buscarPorId(id);
		return ResponseEntity.ok().body(pedidoRetorno);
		
	}
	
}
