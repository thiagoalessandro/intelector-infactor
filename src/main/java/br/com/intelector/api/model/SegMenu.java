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
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_SEG_MENU")
public class SegMenu extends EntityBasicAbstract{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length=150)
	private String nome;
		
	@Column(name="icone", length=150)
	private String icone;
			
	@Column(name="ordem")
	private Integer ordem;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SegSubMenu> listSubMenu;
	
	@Column(name="rota_auxiliar", length=150)
	private String rotaAuxiliar;

	public SegMenu(String nome, String icone, Integer ordem, List<SegSubMenu> listSubMenu) {
		super();
		this.nome = nome;
		this.icone = icone;
		this.ordem = ordem;
		this.listSubMenu = listSubMenu;
	}
	
	
}
