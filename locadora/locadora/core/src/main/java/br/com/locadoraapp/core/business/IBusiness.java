package br.com.locadoraapp.core.business;

import java.util.List;

public interface IBusiness<T> {

	public T inserir(T object);
	
	public List<T> listar();
	
	public void excluir(T object);
	

}
