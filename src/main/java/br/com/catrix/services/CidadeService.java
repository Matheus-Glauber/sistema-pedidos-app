package br.com.catrix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.catrix.entities.Cidade;
import br.com.catrix.repositories.CidadeRepository;
import br.com.catrix.services.exception.NegocioNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Cidade> buscaCidades() {
		return cidadeRepository.findAll();
	}
	
	public Cidade busCidadePorId(Long id) {
		Optional<Cidade> cidadeRetorno = cidadeRepository.findById(id);
		return cidadeRetorno.orElseThrow(() -> new NegocioNotFoundException("Cidade não encontrada, Id: " + id));
	}

}
