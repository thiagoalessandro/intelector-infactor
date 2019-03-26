package br.com.intelector.api.model.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SimNaoConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return attribute ? "S" : "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return "S".equals(dbData);
	}

}
