package br.com.catrix.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ESTADO")
@EqualsAndHashCode(exclude = {"serialVersionUID", "estado", "cidades"}) @AllArgsConstructor @NoArgsConstructor @ToString
public class Estado implements Serializable {

	private static final long serialVersionUID = -3736968647931261525L;
	
	@Getter
	@ApiModelProperty(value = "Código do Estado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Getter @Setter
	@ApiModelProperty(value = "Estado")
	@Column(name = "ESTADO")
	private String estado;
	
	@Getter @Setter
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<Cidade>();

}
