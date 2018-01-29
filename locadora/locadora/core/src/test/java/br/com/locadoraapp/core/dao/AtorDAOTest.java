package br.com.locadoraapp.core.dao;

import java.util.List;

import org.junit.Test;

import br.com.locadoraapp.core.HibernateDbUnitTestCase;
import br.com.locadoraapp.core.hibernate.dao.AtorDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IAtorDAO;
import br.com.locadoraapp.core.modelo.Ator;

public class AtorDAOTest extends HibernateDbUnitTestCase{
	
	
	private IAtorDAO dao;

	
	@Test
	public void testarInsert() {
		
		final String nomeAtor = "Danny Glover";
		
		dao = new AtorDAOImpl(session);
		
		Ator atorGravado = dao.inserir(new Ator(nomeAtor));
		
		assertNotNull(atorGravado);
	}
	
	
	@Test
	public void testAtualizar() {
		
		dao = new AtorDAOImpl(session);
		
		Ator ator = dao.getAtor(1L);
		assertEquals("Mel Gibson", ator.getNome());
		
		ator.setNome("Charlie Sheen");
		Ator atorAlterado = dao.alterar(ator);		
		assertEquals("Charlie Sheen", atorAlterado.getNome());
		
	}
	
	
	@Test
	public void testarPesquisa() {
		
		dao = new AtorDAOImpl(session);
		List<Ator> atores = dao.getAll();
		
		assertEquals(2, atores.size());
	}
	
	
}
