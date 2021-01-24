package br.com.catrix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.catrix.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> cat = new ArrayList<Categoria>();
		cat.add(cat1);
		cat.add(cat2);
		
		return cat;
	}

}
