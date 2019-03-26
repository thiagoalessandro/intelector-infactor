package br.com.intelector.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_SEG_FUNCIONALIDADE")
public class SegFuncionalidade extends EntityBasicAbstract{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 100)
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=150)
	private String descricao;
	
	@Column(name="rota", length=50)
	private String rota;
		
	@OneToMany(mappedBy = "funcionalidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderBy("ordem")
	private List<SegFuncionalidadeOperacao> listFuncionalidadeOperacao;

	public SegFuncionalidade(String nome, String descricao, String rota,
			List<SegFuncionalidadeOperacao> listFuncionalidadeOperacao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.rota = rota;
		this.listFuncionalidadeOperacao = listFuncionalidadeOperacao;
	}
	
}
