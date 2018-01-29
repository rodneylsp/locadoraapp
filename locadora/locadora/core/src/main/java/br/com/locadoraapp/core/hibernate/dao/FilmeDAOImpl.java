package br.com.locadoraapp.core.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.locadoraapp.core.modelo.Filme;

public class FilmeDAOImpl extends DAO<Filme> implements IFilmeDAO{

	
	private Session sessao;
	
	public FilmeDAOImpl() {
		super();
		sessao = getSession();
	}
	
	public FilmeDAOImpl(Session session) {
		super();
		sessao = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> getAll() {
		
		List<Filme> filmes = new ArrayList<Filme>();
		
		Query query = sessao.createQuery("from Filme");
		filmes.addAll(query.list());
		
		return filmes;
	}


}
