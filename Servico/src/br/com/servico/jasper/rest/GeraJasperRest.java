package br.com.servico.jasper.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.servico.jasper.dto.ObjetoDTO;
import br.com.servico.jasper.request.GeraJasperRequest;
import br.com.servico.jasper.response.GeraJasperResponse;
import br.com.servico.jasper.service.impl.GeraArquivoService;
import br.com.servico.jasper.util.TemplateJasperEnum;
import br.com.servico.jasper.util.TipoExportacao;

@Path("/jasper")
public class GeraJasperRest {

	@GET
	@Produces("application/json")
	@Path("/impressao")
	public String impressaoModeloRelatorio() {

		final GeraJasperRequest geraArquivoRequest = new GeraJasperRequest();
		geraArquivoRequest.getTemplateJasper().add(TemplateJasperEnum.TEMPLATE_RELATORIO_TESTE);
		geraArquivoRequest.setTipoExportacao(TipoExportacao.PDF);
		final List<ObjetoDTO> lista = new ArrayList<ObjetoDTO>();
		
		ObjetoDTO dto = new ObjetoDTO();
		dto.setCodigo(1000l);
		dto.setTitulo("Teste para Impressão");
		dto.setDescricao("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.");
		
		lista.add(dto);
		geraArquivoRequest.setDados(lista);
		geraArquivoRequest.getParametros().put("LOGO_ESQ_URL",
				"http://bestwesternashoka.com/wp-content/uploads/2014/11/Free-1Mbs-Wifi-access.png");
		geraArquivoRequest.getParametros().put("LOGO_DIR_URL",
				"https://upload.wikimedia.org/wikipedia/commons/9/9b/Inernet.jpg");

		GeraArquivoService gerar = new GeraArquivoService();
		final GeraJasperResponse geraArquivoResponse = gerar.gerarJasper(geraArquivoRequest);
		String encoded = null;
		if(geraArquivoResponse.getByteJasper() != null){
			encoded = Base64.getEncoder().encodeToString(geraArquivoResponse.getByteJasper());
		}else{
			encoded = "Erro!";
		}
		return encoded;
	}


}
