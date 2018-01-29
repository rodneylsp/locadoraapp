package br.com.locadoraapp.core.business;

import java.util.ArrayList;
import java.util.List;

import br.com.locadoraapp.core.exception.DadoObrigatorioException;
import br.com.locadoraapp.core.exception.LocadoraAppException;
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
	public Ator inserir(Ator ator) throws LocadoraAppException{
		
		if(ator == null) {
			throw new DadoObrigatorioException("Objeto nulo");
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

	@Override
	public Ator alterar(Ator object) throws LocadoraAppException {
		Ator ator = dao.alterar(object);
		return ator;
	}
	
	


}
