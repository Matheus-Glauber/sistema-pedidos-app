package br.com.catrix.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CIDADE")
@EqualsAndHashCode(exclude = {"cidade"}) @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Cidade implements Serializable {

	private static final long serialVersionUID = -3426057513303683590L;
	
	@Getter
	@ApiModelProperty(value = "Código da Cidade")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Getter @Setter
	@ApiModelProperty(value = "Cidade")
	@Column(name = "CIDADE")
	private String cidade;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="ESTADO_ID")
	private Estado estado;

}
