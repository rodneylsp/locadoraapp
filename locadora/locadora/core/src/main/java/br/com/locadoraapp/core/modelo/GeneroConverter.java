package br.com.locadoraapp.core.modelo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter criado para substituir o enum pelo código ao ser persistido na base.
 * 
 * @author rodney
 *
 */
@Converter(autoApply=true)
public class GeneroConverter implements AttributeConverter<GeneroEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(GeneroEnum arg0) {
		Integer codigo = arg0.getCodigo();
		return codigo;
	}

	@Override
	public GeneroEnum convertToEntityAttribute(Integer arg0) {
		return GeneroEnum.fromCodigo(arg0);
	}

}
