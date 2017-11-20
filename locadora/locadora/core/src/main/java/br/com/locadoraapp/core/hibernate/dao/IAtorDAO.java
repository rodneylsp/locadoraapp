package br.com.locadoraapp.core.hibernate.dao;

import br.com.locadoraapp.core.modelo.Ator;

public interface IAtorDAO extends IDAO<Ator>{

	public Ator getAtor(Long id);
}
