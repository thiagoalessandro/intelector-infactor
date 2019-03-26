package br.com.intelector.api.model.enums;

import java.util.Arrays;
import java.util.List;

public enum SituacaoEnum implements EnumBasicInterface<SituacaoEnum>{

	Ativo("A"),
	Inativo("I"),
	Excluido("E");
	
	private String name;

	SituacaoEnum(String name) {
		this.name = name; 
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public List<SituacaoEnum> list() {
		return Arrays.asList(Ativo, Inativo, Excluido);
	}	
	
	public static SituacaoEnum convertStringToEnum(String situacao) {
		switch (situacao) {
			case "A" :
				return SituacaoEnum.Ativo;
			case "I" :
				return SituacaoEnum.Inativo;
			case "E" :
				return SituacaoEnum.Excluido;
			default:
				return SituacaoEnum.Ativo;
		}
	}
	
	
}
