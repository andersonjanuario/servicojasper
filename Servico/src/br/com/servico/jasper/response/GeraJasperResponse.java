package br.com.servico.jasper.response;

import java.io.Serializable;


/**
 * The Class GeraJasperResponse.
 */
public class GeraJasperResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7709880611991615059L;
	
	/** The byte jasper. */
	private byte[] byteJasper;

	/**
	 * Gets the byte jasper.
	 *
	 * @return the byte jasper
	 */
	public final byte[] getByteJasper() {
		return byteJasper;
	}

	/**
	 * Sets the byte jasper.
	 *
	 * @param byteJasper the new byte jasper
	 */
	public final void setByteJasper(byte[] byteJasper) {
		this.byteJasper = byteJasper;
	}
	
}
