package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.catrix.dto.AdicionarClienteDTO;
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
	
	public void salvarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Cliente fromDTO(AdicionarClienteDTO adicionarClienteDTO) {
		return new Cliente(adicionarClienteDTO.getId(), adicionarClienteDTO.getNome(), adicionarClienteDTO.getEmail(), adicionarClienteDTO.getCpfOuCnpj(), adicionarClienteDTO.getTipoCliente());
	}

	public Cliente atualizarCliente(Cliente cliente) {
		buscarClientePorId(cliente.getId());
		return clienteRepository.save(cliente);
	}

	public void excluirCliente(Long id) {
		buscarClientePorId(id);
		try {
			clienteRepository.deleteById(id);					
		} catch (DataIntegrityViolationException e) {
			throw new NegocioNotFoundException("Não é possível excluir um cliente, que possua endereços relacionados");
		}
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
}
