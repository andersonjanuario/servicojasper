package br.com.servico.jasper.util;


/**
 * The Enum TipoExportacao.
 */
public enum TipoExportacao {

	/** The pdf. */
	PDF("PDF"),
	
	/** The png. */
	PNG("PNG");//mime type: application/pdf; charset=binary


	/** The tipo exportacao. */
private final String tipoExportacao;

	/**
	 * Instantiates a new tipo exportacao.
	 *
	 * @param inTipoExportacao the in tipo exportacao
	 */
	private TipoExportacao(final String inTipoExportacao) {
		this.tipoExportacao = inTipoExportacao;
	}

	/**
	 * Gets the tipo exportacao arquivo.
	 *
	 * @return the tipo exportacao arquivo
	 */
	public String getTipoExportacaoArquivo() {
		return tipoExportacao;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		String retorno = "";
		if (PDF.getTipoExportacaoArquivo()
				.equals(tipoExportacao)) {
			retorno = "application/pdf";
		}else if (PNG.getTipoExportacaoArquivo().equals(tipoExportacao)) {
            retorno = "image/png";
        }
		return retorno;
	}

	
}
