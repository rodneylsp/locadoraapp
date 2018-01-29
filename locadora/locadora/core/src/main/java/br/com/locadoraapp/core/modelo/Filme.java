package br.com.locadoraapp.core.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="filme")
public class Filme {

	@Id
	@Column(name="film_id", updatable=false, nullable=false)
	@SequenceGenerator(name="filme_generator", sequenceName="filme_filme_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="filme_generator")
	private Long id;
	
	@Column(name="film_titulo")
	private String titulo;
	
	@Column(name="film_sinopse")
	private String sinopse;
	
	@Column(name="film_genero")
	@Convert(converter=GeneroConverter.class)
	private GeneroEnum genero;
	
	@Column(name="film_lancamento")
	private Integer anoLancamento;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="filme_ator", 
		joinColumns= {@JoinColumn(name="film_id")},
		inverseJoinColumns= {@JoinColumn(name="ator_id")})
	private List<Ator> elenco;
	
	
		
	public Filme(Long id, String titulo, String sinopse, GeneroEnum genero, Integer anoLancamento, List<Ator> elenco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.elenco = elenco;
	}
	
	public Filme() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	public Integer getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public List<Ator> getElenco() {
		return elenco;
	}
	public void setElenco(List<Ator> elenco) {
		this.elenco = elenco;
	}
	
	
}
