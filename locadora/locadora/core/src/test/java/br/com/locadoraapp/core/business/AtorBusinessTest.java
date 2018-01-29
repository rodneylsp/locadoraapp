package br.com.locadoraapp.core.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.locadoraapp.core.exception.DadoObrigatorioException;
import br.com.locadoraapp.core.exception.LocadoraAppException;
import br.com.locadoraapp.core.hibernate.dao.AtorDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IAtorDAO;
import br.com.locadoraapp.core.modelo.Ator;

public class AtorBusinessTest {
	
	private IAtorBusiness business;
	
	private final String ATOR = "Keanu Reeves";
	
	@Mock
	private IAtorDAO atorDAO;
	
	@Before
	public void before() {
		
		atorDAO = Mockito.mock(AtorDAOImpl.class);
		business = new AtorBusiness(atorDAO);
				
	}

	@Test(expected=DadoObrigatorioException.class)
	public void testarInserirComAtorSemNome()throws LocadoraAppException {
		
		Ator ator = null;  
		business.inserir(ator);
		Mockito.verify(atorDAO, Mockito.times(1)).inserir(ator);

	}
	
	@Test
	public void testarinserirComSucesso() {
		
		Ator ator = new Ator(ATOR);  
		
		try {
			business.inserir(ator);
		} catch (LocadoraAppException e) {
			e.printStackTrace();
		}
		Mockito.verify(atorDAO, Mockito.times(1)).inserir(ator);

	}
	
	
	//@Test
	public void testarConsultarAtorComSucesso() {
		
		Ator atorRecuperado = business.getAtor(1L);
		assertEquals(ATOR, atorRecuperado.getNome());
	
	}


}
