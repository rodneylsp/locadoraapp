package br.com.locadoraapp.core.modelo;

/**
 * Enum que armazena os possiveis generos dos filmes
 * 
 * @author rodney
 *
 */
public enum GeneroEnum {
	
	ACAO (1, "Ação"),
	COMEDIA (2, "Comédia"),
	DRAMA (3, "Drama"),
	DOCUMENTARIO (4, "Documentário"),
	POLICIAL (5, "Policial"),
	MUSICAL (6, "Musical"),
	ROMANCE (7, "Romance"),
	SUSPENSE (8, "Suspense"),
	TERROR (9, "Terror"),
	FICCAO (10, "Ficção");
	
	private final Integer codigo;
	private final String nome;
	
	GeneroEnum(Integer codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	
	public static GeneroEnum fromCodigo(int codigo) {
		
		switch(codigo) {
		
		case 1:
			return ACAO;
		case 2:
			return COMEDIA;
		case 3:
			return DRAMA;
		case 4:
			return DOCUMENTARIO;
		case 5:
			return POLICIAL;
		case 6:
			return MUSICAL;
		case 7:
			return ROMANCE;
		case 8:
			return SUSPENSE;
		case 9:
			return TERROR;
		case 10:
			return FICCAO;
			
		default:
			throw new IllegalArgumentException("Codigo [" + codigo + "] não suportado.");
		}
	}
	
}
