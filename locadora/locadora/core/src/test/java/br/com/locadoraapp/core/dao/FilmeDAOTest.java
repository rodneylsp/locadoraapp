package br.com.locadoraapp.core.dao;

import java.util.List;

import org.junit.Test;

import br.com.locadoraapp.core.HibernateDbUnitTestCase;
import br.com.locadoraapp.core.hibernate.dao.FilmeDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IFilmeDAO;
import br.com.locadoraapp.core.modelo.Filme;

public class FilmeDAOTest extends HibernateDbUnitTestCase{

	private IFilmeDAO dao;
	
	

	@Test
	public void testPesquisa() {
		
		dao = new FilmeDAOImpl(session);
		List<Filme> filmes = dao.getAll();
		assertEquals(2, filmes.size());
	}
}
