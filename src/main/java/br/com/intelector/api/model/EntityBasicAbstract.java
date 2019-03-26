package br.com.intelector.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.intelector.api.model.enums.SituacaoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntityBasicAbstract implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_sit", length=1)
	private SituacaoEnum situacao;
	
	@Column(name = "cd_usu_atu", length=50)
	private String cdUsuAtu;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atu")
	private Date dhAtu;

	@PrePersist
	public void prePersist() {
		dhAtu = new Date();
		situacao = SituacaoEnum.Ativo;
	}
	
	@PreUpdate
	public void preUpdate() {
		dhAtu = new Date();
	}
	
}
