package br.com.intelector.api.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.intelector.api.model.enums.SituacaoEnum;

@Converter(autoApply = true)
public class SituacaoConverter implements AttributeConverter<SituacaoEnum, String> {

	@Override
	public String convertToDatabaseColumn(SituacaoEnum attribute) {
		return attribute.getName();
	}

	@Override
	public SituacaoEnum convertToEntityAttribute(String dbData) {
		return SituacaoEnum.convertStringToEnum(dbData);
	}

}
