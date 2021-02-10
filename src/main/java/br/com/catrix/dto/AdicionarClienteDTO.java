package br.com.catrix.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import br.com.catrix.entities.enums.TipoCliente;

public class AdicionarClienteDTO implements Serializable {

	private static final long serialVersionUID = 7303778756381104167L;

	private Long id;

	@NotEmpty(message = "Nome não pode ser vazio")
	@Size(min = 3, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
	private String nome;

	@Email(message = "Digite um email valido")
	private String email;

	@NotNull
	@NotEmpty(message = "Cpf ou CNPJ não podem ser vazio")
	@Size(min = 11, max = 14, message = "O CPF ou CNPJ deve ter entre {min} e {max} caracteres")
	private String cpfOuCnpj;
	
	@NotNull
	private TipoCliente tipoCliente;

	public AdicionarClienteDTO() {
	}

	public AdicionarClienteDTO(Long id,
			@NotEmpty(message = "Nome não pode ser vazio") @Size(min = 3, max = 250, message = "Nome deve ter entre {min} e {max} caracteres") String nome,
			@Email(message = "Digite um email valido") String email,
			@NotNull @NotEmpty(message = "Cpf ou CNPJ não podem ser vazio") @Size(min = 11, max = 14, message = "O CPF ou CNPJ deve ter entre {min} e {max} caracteres") String cpfOuCnpj,
			@NotNull TipoCliente tipoCliente) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoCliente = tipoCliente;
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
