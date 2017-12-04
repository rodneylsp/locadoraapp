package br.com.locadoraapp.core.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.locadoraapp.core.modelo.Ator;

public class AtorDAOImpl extends DAO<Ator> implements IAtorDAO {
	
	private Session sessao;
	
	public AtorDAOImpl() {
		super();
		sessao = getSession();
	}
	
	public AtorDAOImpl(Session session) {
		super();
		sessao = session;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Ator> getAll() {
		
		List<Ator> atores = new ArrayList<Ator>();
		
		Query query = sessao.createQuery("from Ator");
		atores.addAll(query.list());
		
		return atores;
	}

	@Override
	public Ator getAtor(Long id) {
		
		 Criteria criteria = sessao.createCriteria(Ator.class);
		 criteria.add(Restrictions.eq("id", id));
		 
		 Ator ator = (Ator)criteria.uniqueResult();
		return ator;
	}


}
