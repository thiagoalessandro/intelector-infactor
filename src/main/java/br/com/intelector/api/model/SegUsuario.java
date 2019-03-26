package br.com.intelector.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_SEG_USUARIO")
public class SegUsuario extends EntityBasicAbstract{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="login", length=20)
	private String login;
	
	@Column(name="email", length=150)
	private String email;

	@Column(name="password", length=255)
	private String password;

	public SegUsuario(String nome, String login, String email, String password) {
		super();
		this.nome = nome;
		this.login = login;
		this.email = email;
		this.password = password;
	}
	
}
