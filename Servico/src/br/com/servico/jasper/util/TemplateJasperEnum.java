package br.com.servico.jasper.util;


/**
 * The Enum TemplateImpressaoEnum.
 */
public enum TemplateJasperEnum {


	/** The template relatorio teste. */
	TEMPLATE_RELATORIO_TESTE("/jasper/RelatorioTeste.jasper");

	/** The template. */
	private final String template;	

	/**
	 * Instantiates a new template impressao enum.
	 *
	 * @param inTemplate the in template
	 */
	private TemplateJasperEnum(final String inTemplate) {
		this.template = inTemplate;
	}

	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}
	
}
