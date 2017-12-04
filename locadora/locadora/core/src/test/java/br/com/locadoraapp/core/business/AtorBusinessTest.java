package br.com.locadoraapp.core.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.com.locadoraapp.core.modelo.Ator;

public class AtorBusinessTest {
	
	private IAtorBusiness business;
	
	private final String ATOR = "Keanu Reeves";
	
	
	//@Before
	public void before() {
		
		business = new AtorBusiness();
	}

	//@Test
	public void testarinserirComSucesso() {
		
		Ator atorInserido  = business.inserir(new Ator(ATOR));
		assertNotNull(atorInserido.getId());

	}
	
	
	//@Test
	public void testarConsultarAtorComSucesso() {
		
		Ator atorRecuperado = business.getAtor(1L);
		assertEquals(ATOR, atorRecuperado.getNome());
	
	}


}
