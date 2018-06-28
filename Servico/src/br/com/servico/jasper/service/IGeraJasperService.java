package br.com.servico.jasper.service;

import br.com.servico.jasper.request.GeraJasperRequest;
import br.com.servico.jasper.response.GeraJasperResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGeraJasperService.
 */
public interface IGeraJasperService {

	/**
	 * Gerar jasper.
	 *
	 * @param geraJasperRequest the gera jasper request
	 * @return the gera jasper response
	 */
	GeraJasperResponse gerarJasper(GeraJasperRequest geraJasperRequest);	
}
