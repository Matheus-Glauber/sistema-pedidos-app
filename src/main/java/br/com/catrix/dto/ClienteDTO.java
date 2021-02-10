package br.com.catrix.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.catrix.entities.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = -3872348654197287658L;

	private Long id;
	
	@NotEmpty
	@Size(min = 3, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
	private String nome;

	@Email
	private String email;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
