package br.com.catrix.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CATEGORIA")
@EqualsAndHashCode(exclude = {"serialVersionUID", "nome", "produtos"}) @AllArgsConstructor @NoArgsConstructor @ToString
public class Categoria implements Serializable {

	private static final long serialVersionUID = 4287881982766690017L;

	@Getter
	@ApiModelProperty(value = "Código da categoria")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Getter @Setter
	@ApiModelProperty(value = "Nome da Categoria")
	@Column(name = "NOME")
	private String nome;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<Produto>();

}
