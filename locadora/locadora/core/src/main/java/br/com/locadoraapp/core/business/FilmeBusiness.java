package br.com.locadoraapp.core.business;

import java.util.List;

import br.com.locadoraapp.core.exception.DadoObrigatorioException;
import br.com.locadoraapp.core.exception.LocadoraAppException;
import br.com.locadoraapp.core.hibernate.dao.FilmeDAOImpl;
import br.com.locadoraapp.core.hibernate.dao.IFilmeDAO;
import br.com.locadoraapp.core.modelo.Filme;

public class FilmeBusiness implements IFilmeBusiness{
	
	private IFilmeDAO dao;
	
	
	public FilmeBusiness() {
		super();
		this.dao = new FilmeDAOImpl();
	}
	
	public FilmeBusiness(IFilmeDAO dao) {
		this.dao = dao;
	}

	@Override
	public Filme inserir(Filme filme) throws LocadoraAppException {
		
		if((filme == null || filme.getTitulo() == null)) {
			throw new DadoObrigatorioException("Titulo é obrigatorio");
		}
		
		if((filme == null || filme.getElenco() == null)) {
			throw new DadoObrigatorioException("Elenco e obrigatorio");
		}
		
		Filme filmeGravado = this.dao.inserir(filme);
		return filmeGravado;
	}

	@Override
	public List<Filme> listar() {
		
		List<Filme> filmes = this.dao.getAll();
		return filmes;
	}

	@Override
	public void excluir(Filme object) {
		this.dao.excluir(object);
	}

	@Override
	public Filme alterar(Filme object) {
		Filme filme = this.dao.alterar(object);
		return filme;
	}

	
}
