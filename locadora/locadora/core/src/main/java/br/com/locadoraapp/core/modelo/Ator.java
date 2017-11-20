package br.com.locadoraapp.core.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ator")
public class Ator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597225101224303042L;
	

	@Id
	@Column(name="ator_id", updatable=false, nullable=false)
	@SequenceGenerator(name="ator_generator", sequenceName="ator_ator_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ator_generator")
	private Long id;
	
	@Column(name="ator_nome")
	private String nome;
	
	
	
	public Ator(String nome) {
		super();
		this.nome = nome;
	}
	
	public Ator() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
