package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Estado;
import br.com.catrix.repositories.EstadoRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}
	
	public Estado buscarPorId(Long id) {
		Optional<Estado> estadoRetorno = estadoRepository.findById(id);
		return estadoRetorno.orElseThrow(() -> new NegocioNotFoundException("Estado não encontrado, Id: " + id));
	}

}
