package br.com.intelector.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_SEG_OPERACAO")
public class SegOperacao extends EntityBasicAbstract{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length=150)
	private String nome;
	
	@Column(name="descricao", length=150)
	private String descricao;
	
	@Column(name="icone", length=150)
	private String icone;
	
	@Column(name="rota")
	private String rota;

	public SegOperacao(String nome, String descricao, String icone, String rota) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.icone = icone;
		this.rota = rota;
	}				
	
}
