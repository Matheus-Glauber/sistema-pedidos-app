package br.com.catrix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.catrix.entities.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = -4425538482454586666L;

	private Long id;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Length(min = 8, max = 80, message = "O tamanho deve ser entre {min} e {max} caracteres!")
	private String nome;

	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
