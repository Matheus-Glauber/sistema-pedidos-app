package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Endereco;
import br.com.catrix.repositories.EnderecoRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> buscarTodosOsEnderecos() {
		return enderecoRepository.findAll();
	}
	
	public Endereco buscarEnderecoPorId(Long id) {
		Optional<Endereco> enderecoRetorno = enderecoRepository.findById(id);
		return enderecoRetorno.orElseThrow(() -> new NegocioNotFoundException("Endereço não encontrado, Id: " + id));
	}

}
