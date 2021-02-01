package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Cliente;
import br.com.catrix.repositories.ClienteRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodos() {
		
		return clienteRepository.findAll();
		
	}
	
	public Cliente buscarClientePorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		return cliente.orElseThrow(() -> new NegocioNotFoundException("Cliente não encontrado, Id: " + id));
	}

}
