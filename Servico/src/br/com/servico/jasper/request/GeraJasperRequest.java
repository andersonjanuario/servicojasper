package br.com.servico.jasper.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.servico.jasper.util.TemplateJasperEnum;
import br.com.servico.jasper.util.TipoExportacao;


/**
 * The Class GeraJasperRequest.
 */
public class GeraJasperRequest {

	/** The dados. */
	private List<?> dados;
	
	/** The tipo exportacao. */
	private TipoExportacao tipoExportacao;
	
	/** The parametros. */
	private HashMap<String, Object> parametros;
	
	/** The template jasper. */
	private List<TemplateJasperEnum> templateJasper;



	/**
	 * Gets the tipo exportacao.
	 *
	 * @return the tipo exportacao
	 */
	public TipoExportacao getTipoExportacao() {
		return tipoExportacao;
	}

	/**
	 * Sets the tipo exportacao.
	 *
	 * @param tipoExportacao the new tipo exportacao
	 */
	public void setTipoExportacao(TipoExportacao tipoExportacao) {
		this.tipoExportacao = tipoExportacao;
	}

	/**
	 * Gets the dados.
	 *
	 * @return the dados
	 */
	public List<?> getDados() {
		if (dados == null) {
			dados = new ArrayList<>();
		}
		return dados;
	}

	/**
	 * Sets the dados.
	 *
	 * @param dadosImpressao the new dados
	 */
	public void setDados(List<?> dadosImpressao) {
		this.dados = dadosImpressao;
	}

	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public HashMap<String, Object> getParametros() {
		if (parametros == null) {
			parametros = new HashMap<String, Object>();
		}
		return parametros;
	}

	/**
	 * Sets the parametros.
	 *
	 * @param parametros the parametros
	 */
	public void setParametros(final HashMap<String, Object> parametros) {
		this.parametros = parametros;
	}

	/**
	 * Gets the template jasper.
	 *
	 * @return the template jasper
	 */
	public List<TemplateJasperEnum> getTemplateJasper() {
		if (templateJasper == null) {
			templateJasper = new ArrayList<>();
		}
		return templateJasper;
	}

	/**
	 * Sets the template jasper.
	 *
	 * @param templateImpressao the new template jasper
	 */
	public void setTemplateJasper(final List<TemplateJasperEnum> templateImpressao) {
		this.templateJasper = templateImpressao;
	}

	
}
