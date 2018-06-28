package br.com.servico.jasper.dto;


/**
 * The Class ObjetoDTO.
 */
public class ObjetoDTO {
	
	/** The codigo. */
	private Long codigo;
	
	/** The titulo. */
	private String titulo;
	
	/** The descricao. */
	private String descricao;

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	
	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Instantiates a new objeto dto.
	 */
	public ObjetoDTO() {
		super();		
	}	
	
	/**
	 * Instantiates a new objeto dto.
	 *
	 * @param codigo the codigo
	 * @param titulo the titulo
	 * @param descricao the descricao
	 */
	public ObjetoDTO(Long codigo, String titulo, String descricao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	
}
