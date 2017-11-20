package br.com.locadoraapp.core.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.locadoraapp.core.modelo.Ator;

public class AtorBusinessTest {
	
	private IAtorBusiness business;
	
	private final String ATOR = "Keanu Reeves";
	
	
	@Before
	public void before() {
		
		business = new AtorBusiness();
		
	}

	@Test
	public void testarCRUD() {
		
		
		Ator atorInserido  = business.inserir(new Ator(ATOR));
		
		List<Ator> atores = business.listar();
		
		Ator atorRecuperado = business.getAtor(atorInserido.getId());
		assertEquals(ATOR, atorRecuperado.getNome());
		
		business.excluir(atorInserido);
		
		assertEquals(1, atores.size());
		
		
	}
}
