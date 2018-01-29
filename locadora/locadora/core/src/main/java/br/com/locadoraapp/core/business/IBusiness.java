package br.com.locadoraapp.core.business;

import java.util.List;

import br.com.locadoraapp.core.exception.LocadoraAppException;

public interface IBusiness<T> {

	public T inserir(T object)throws LocadoraAppException;
	
	public List<T> listar();
	
	public void excluir(T object);
	
	public T alterar(T object)throws LocadoraAppException;
	

}
