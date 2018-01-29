package br.com.locadoraapp.core.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.locadoraapp.core.exception.DadoObrigatorioException;
import br.com.locadoraapp.core.exception.LocadoraAppException;
import br.com.locadoraapp.core.hibernate.dao.FilmeDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IFilmeDAO;
import br.com.locadoraapp.core.modelo.Ator;
import br.com.locadoraapp.core.modelo.Filme;
import br.com.locadoraapp.core.modelo.GeneroEnum;

public class FilmeBusinessTest {

	private IFilmeBusiness business;
	
	private Filme filme;
	
	@Mock
	private IFilmeDAO filmeDAO;
	
	@Before
	public void before() {
		
		this.filme = new Filme();
		this.filme.setTitulo("Matrix");
		this.filme.setAnoLancamento(1999);
		this.filme.setGenero(GeneroEnum.FICCAO);
		this.filme.setSinopse("xxxx xxxxx xxxxx xxxxx");
		List<Ator> elenco = new ArrayList<>();
		elenco.add(new Ator("KeanuReeves"));
		elenco.add(new Ator("Lawrence Fishburne"));
		this.filme.setElenco(elenco);
		
		filmeDAO = Mockito.mock(FilmeDAOImpl.class);
		business = new FilmeBusiness(filmeDAO);
	}
	
	
	@Test
	public void testListarFilmes() {
	
		//define que quando o dao chamar o metodo deve retornar a lista
		Mockito.when(filmeDAO.getAll()).thenReturn(this.getListaDeFilmes());
		
		List<Filme> filmes = business.listar();
		
		Mockito.verify(filmeDAO, Mockito.times(1)).getAll();
		assertEquals(2, filmes.size());
	}
	
	
	@Test
	public void testInserirFilme() {
		
		try {
			business.inserir(filme);
		} catch (LocadoraAppException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=DadoObrigatorioException.class)
	public void testInserirFilmeSemTitulo() throws LocadoraAppException {
		
		this.filme.setTitulo(null);
		business.inserir(this.filme);

	}
	
	@Test(expected=DadoObrigatorioException.class)
	public void testInserirFilmeSemElenco() throws LocadoraAppException {
		
		this.filme.setElenco(null);
		business.inserir(filme);

	}
	
	private List<Filme> getListaDeFilmes(){
		
		Filme filme = new Filme();
		filme.setTitulo("Matrix");
		filme.setAnoLancamento(1999);
		filme.setGenero(GeneroEnum.FICCAO);
		filme.setSinopse("xxxx xxxxx xxxxx xxxxx");
		List<Ator> elenco = new ArrayList<>();
		elenco.add(new Ator("KeanuReeves"));
		elenco.add(new Ator("Lawrence Fishburne"));
		filme.setElenco(elenco);
		
		Filme filme2 = new Filme();
		filme2.setTitulo("Predador, O");
		filme2.setAnoLancamento(1986);
		filme2.setGenero(GeneroEnum.FICCAO);
		filme2.setSinopse("xxxx xxxxx xxxxx xxxxx");
		List<Ator> elenco2 = new ArrayList<>();
		elenco2.add(new Ator("Arnold Schwarzenneger"));
		elenco2.add(new Ator("Carl Weathers"));
		filme.setElenco(elenco2);
		
		List<Filme> filmes = new ArrayList<>();
		filmes.add(filme);
		filmes.add(filme2);
		
		return filmes;
		
	}
	
	
}
