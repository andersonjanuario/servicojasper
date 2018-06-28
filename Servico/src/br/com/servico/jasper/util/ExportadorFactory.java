package br.com.servico.jasper.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;


/**
 * A factory for creating Exportador objects.
 */
public class ExportadorFactory {
	
	/**
	 * Exportar.
	 *
	 * @param tipoExportacao the tipo exportacao
	 * @param jasperPrint the jasper print
	 * @return the byte[]
	 * @throws JRException the JR exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static byte[] exportar(final TipoExportacao tipoExportacao, final JasperPrint jasperPrint) throws JRException, IOException{
		
		byte[] bytesArquivo = null;
		
		if (TipoExportacao.PDF.equals(tipoExportacao)) {			
			bytesArquivo = JasperExportManager.exportReportToPdf(jasperPrint);
		}else if (TipoExportacao.PNG.equals(tipoExportacao)) {          
            bytesArquivo = exportarImagem(jasperPrint);
        } 
		
		return bytesArquivo;
	}
	
	
	/**
	 * Exportar imagem.
	 *
	 * @param jasperPrint the jasper print
	 * @return the byte[]
	 * @throws JRException the JR exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static byte[] exportarImagem(final JasperPrint jasperPrint) throws JRException, IOException{
	    
	    final Float zoom = 2.5F;
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    Integer totalPaginas = jasperPrint.getPages().size();
	    BufferedImage result = new BufferedImage((int) (jasperPrint.getPageWidth()*zoom),
	            (int) ((jasperPrint.getPageHeight() * totalPaginas) * zoom), BufferedImage.TYPE_INT_RGB);
	    Graphics g = result.getGraphics();
	    Integer altura = 0;

	    for (int i = 0; i < totalPaginas; i++) {
        
	        Float alturaPagina = jasperPrint.getPageHeight()*zoom;
	        BufferedImage pageImage = new BufferedImage((int) (jasperPrint.getPageWidth()*zoom),
	                 alturaPagina.intValue(), BufferedImage.TYPE_INT_RGB);
	        JRGraphics2DExporter exporter = new JRGraphics2DExporter();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, pageImage.getGraphics());
	        exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, zoom);
	        exporter.setParameter(JRExporterParameter.PAGE_INDEX, i);
	        exporter.exportReport();
	        g.drawImage(pageImage, 0, altura, null);
	        altura = altura + alturaPagina.intValue();
        }
	    ImageIO.write(result, "png", os);
        return os.toByteArray();
	    
	}
	
}
