package br.com.locadoraapp.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.locadoraapp.core.modelo.Ator;
import br.com.locadoraapp.core.modelo.Filme;
import br.com.locadoraapp.core.modelo.GeneroEnum;

/**
 * Servlet implementation class FilmeServlet
 */
@WebServlet("/filmes")
public class FilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static List<Filme> filmes = new ArrayList<Filme>();

    /**
     * Default constructor. 
     */
    public FilmeServlet() {
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		//Filme 1
		Ator keanuReeves = new Ator("Keanu Reeves");
		Ator alPacino = new Ator("Al Pacino");
		List<Ator> elenco1 = new ArrayList<Ator>();
		elenco1.add(keanuReeves);
		elenco1.add(alPacino);
		
		Filme advogadoDoDiabo = new Filme(
				1L, 
				"Advogado do Diabo", 
				"", 
				GeneroEnum.SUSPENSE, 
				1997, 
				elenco1);
		
		filmes.add(advogadoDoDiabo);
		
		
		//Filme 2
		Ator lawrenceFishburne = new Ator("Lawrence Fishburne");
		List<Ator> elenco2= new ArrayList<Ator>();
		elenco2.add(keanuReeves);
		elenco2.add(lawrenceFishburne);
		
		Filme matrix = new Filme(
				2L, 
				"Matrix", 
				"", 
				GeneroEnum.FICCAO, 
				1999, 
				elenco2);
		
		filmes.add(matrix);
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/plain");
		 
		 		 
		 PrintWriter out = response.getWriter();
		 
		 ObjectMapper convertJson = new ObjectMapper();
		 
		 String jsonInString = convertJson.writerWithDefaultPrettyPrinter().writeValueAsString(filmes);
		 out.print(jsonInString);
		 out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
