package br.com.locadoraapp.core.business;

import java.util.ArrayList;
import java.util.List;

import br.com.locadoraapp.core.hibernate.dao.AtorDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IAtorDAO;
import br.com.locadoraapp.core.modelo.Ator;

public class AtorBusiness implements IAtorBusiness{
	
	private IAtorDAO dao;
	
	public AtorBusiness() {
		super();
		
		dao = new AtorDAOImpl();
	}
	
	public AtorBusiness(IAtorDAO dao) {
		
		
		this.dao = dao;
	}
	

	@Override
	public Ator inserir(Ator ator) {
		
		if(ator == null) {
			throw new IllegalArgumentException("Objeto nulo");
		}
		
		Ator atorGravado = dao.inserir(ator);
		
		return atorGravado;
	}

	@Override
	public List<Ator> listar() {
		
		List<Ator> atores = new ArrayList<>();
		atores.addAll(dao.getAll());
		
		return atores;
	}


	@Override
	public void excluir(Ator objeto) {
		
		dao.excluir(objeto);
		
	}

	
	@Override
	public Ator getAtor(Long id) {
		
		Ator ator = dao.getAtor(id);
		return ator;
	}
	
	


}
