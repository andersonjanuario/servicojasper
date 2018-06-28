package br.com.servico.jasper.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import br.com.servico.jasper.request.GeraJasperRequest;
import br.com.servico.jasper.response.GeraJasperResponse;
import br.com.servico.jasper.service.IGeraJasperService;
import br.com.servico.jasper.util.ExportadorFactory;
import br.com.servico.jasper.util.TemplateJasperEnum;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class GeraArquivoService implements IGeraJasperService {

	/* (non-Javadoc)
	 * @see com.servico.IGeraArquivoService#gerarArquivo(com.servico.GeraArquivoRequest)
	 */
	@Override
	public GeraJasperResponse gerarJasper(GeraJasperRequest geraJasperRequest) {
		
		GeraJasperResponse geraArquivoResponse = new GeraJasperResponse();
		InputStream fis = null;
		byte[] byteArquivo = null;

		try {
			JasperPrint relatorio = null;
			for (TemplateJasperEnum template : geraJasperRequest.getTemplateJasper()) {
				fis = this.getClass().getResourceAsStream(template.getTemplate());
				//fis = new FileInputStream(new File("C:\\Users\\deibson.a.januario\\workspaceestudo\\Servico\\src\\main\\resources\\jasper\\RelatorioTeste.jasper"));
        		HashMap<String, Object> param = geraJasperRequest.getParametros();
				param.put("REPORT_LOCALE", new Locale("pt", "BR"));
				if (fis != null) {
					JasperPrint jasperPrint = JasperFillManager.fillReport(fis, param,
							getJRDataSource(geraJasperRequest.getDados()));
							
					if (relatorio == null) {
						relatorio = jasperPrint;
					} else {
						for (JRPrintPage page : jasperPrint.getPages()) {
							relatorio.addPage(page);
						}
					}
				}
			}
			if (relatorio != null) {
				byteArquivo = ExportadorFactory.exportar(geraJasperRequest.getTipoExportacao(),
						relatorio);
				geraArquivoResponse.setByteJasper(byteArquivo);
			}

		} catch (Exception e) {
			System.out.println("Erro!!!!");
		}
		return geraArquivoResponse;		
	}

	/**
	 * @return Retorna bean com os dados do relatório.
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private JRDataSource getJRDataSource(List<?> dadosImpressao)
			throws IllegalArgumentException, IllegalAccessException {
		return new JRBeanCollectionDataSource(dadosImpressao);
	}

}
