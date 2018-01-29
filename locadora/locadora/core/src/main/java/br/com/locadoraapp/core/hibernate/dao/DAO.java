package br.com.locadoraapp.core.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.locadoraapp.core.hibernate.HibernateUtil;


public abstract class DAO<T> implements IDAO<T>{
	
	private static final ThreadLocal<Session> session = new ThreadLocal<>();
	
	protected DAO() {
		
	}

	/**
	 * Recupera uma instancia unica de session
	 * @return sessao com banco de dados
	 */
	public static Session getSession() {
		
		Session sessao = (Session) DAO.session.get();
		
		if(sessao == null) {
			sessao = new HibernateUtil().getSessionFactory().openSession();
			DAO.session.set(sessao);
		}
		
		return sessao;
	}
	
	
	/**
	 * Inicia uma transação com banco de dados
	 */
	protected void begin() {
		getSession().beginTransaction();
	}
	
	
	/**
	 * Comita uma transação no banco de dados
	 */
	protected void commit() {
		getSession().getTransaction().commit();
	}
	
	
	/**
	 * Desfaz as operações com banco de dados
	 */
	protected void roolback() {
		try {
		
			getSession().getTransaction().rollback();
			
		}catch (HibernateException e) {
			System.out.println("Não foi possivel fazer rollback da transação.");
			
		}
		
		try {
			getSession().close();	
		}catch (HibernateException e) {
			System.out.println("Não foi possível fechar a sessão");
		}
		
		DAO.session.set(null);
		
	}
	
	
	/**
	 * Inserir objeto
	 * 
	 * @param objeto
	 * 
	 * @return objeto persistido
	 */
	public T inserir(T object) {
		
		begin();
		getSession().save(object);
		commit();
		
		return object;
	}
	
	public void excluir(T object) {
		
		begin();
		getSession().delete(object);
		commit();
	}
	
	protected static void close() {
		getSession().close();
		DAO.session.set(null);
	}
	
	public T alterar(T object) {
		
		begin();
		getSession().merge(object);
		commit();
		
		return object;
	}

	
	public abstract List<T> getAll();
	
	
}
