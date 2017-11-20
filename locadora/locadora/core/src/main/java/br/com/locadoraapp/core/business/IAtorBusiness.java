package br.com.locadoraapp.core.business;

import br.com.locadoraapp.core.modelo.Ator;

public interface IAtorBusiness extends IBusiness<Ator>{

	public Ator getAtor(Long id);
}
