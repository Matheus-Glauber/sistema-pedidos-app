package br.com.catrix.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUTO")
@EqualsAndHashCode(exclude = {"serialVersionUID", "nome", "preco", "categorias"}) @AllArgsConstructor @NoArgsConstructor @ToString
public class Produto implements Serializable {

	private static final long serialVersionUID = -896927962269714775L;

	@Getter
	@ApiModelProperty(value = "Código do produto")
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter @Setter
	@ApiModelProperty(value = "Nome do produto")
	@Column(name = "NOME")
	private String nome;

	@Getter @Setter
	@ApiModelProperty(value = "Preço do produto")
	@Column(name = "PRECO")
	private Double preco;
	
	@Getter @Setter
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", 
		joinColumns = @JoinColumn(name = "PRODUTO_ID"),
		inverseJoinColumns = @JoinColumn(name = "CATEGORIA_ID"))
	@JsonBackReference
	private List<Categoria> categorias = new ArrayList<Categoria>();

}
