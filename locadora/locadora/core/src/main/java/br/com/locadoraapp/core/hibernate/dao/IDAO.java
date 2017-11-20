package br.com.locadoraapp.core.hibernate.dao;

import java.util.List;


public interface IDAO<T> {
	
	public T inserir(T objeto);
	
	public void excluir(T objeto);
	
	public List<T> getAll();
}
