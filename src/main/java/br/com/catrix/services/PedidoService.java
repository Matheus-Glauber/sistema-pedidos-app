package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Pedido;
import br.com.catrix.repositories.PedidoRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> buscarTodos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido buscarPorId(Long id) {
		Optional<Pedido> PedidoRetorno = pedidoRepository.findById(id);
		return PedidoRetorno.orElseThrow(() -> new NegocioNotFoundException("Pedido não encontrado, Id: " + id));
	}

}
