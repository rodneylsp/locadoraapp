package br.com.locadoraapp.core.hibernate.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.locadoraapp.core.modelo.GeneroEnum;

@Converter
public class GeneroConverter implements AttributeConverter<Integer, GeneroEnum>{

	@Override
	public GeneroEnum convertToDatabaseColumn(Integer arg0) {
		if(arg0 == null) {
			return null;
		}
		return GeneroEnum.fromCodigo(arg0);
	}

	@Override
	public Integer convertToEntityAttribute(GeneroEnum arg0) {
		if(arg0 == null) {
			return null;
		}
		
		return arg0.getCodigo();
	}

}
