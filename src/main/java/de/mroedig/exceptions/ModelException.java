/*
 * and open the template in the editor.
 */
package de.mroedig.exceptions;

/**
 * 
 * @author lfstad-rom
 */
public class ModelException extends RuntimeException {

	/**
	 * Serial-ID
	 */
	private static final long serialVersionUID = -8322622863705977769L;

	/**
	 * Default-Konstruktor
	 */
	public ModelException() {
		super();
	}

	/**
	 * Konstruktor
	 * 
	 * @param message
	 *            Meldung
	 * @param cause
	 *            Throwable
	 */
	public ModelException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 *            Meldung
	 */
	public ModelException(final String message) {
		super(message);
	}

	/**
	 * Konstruktor
	 * 
	 * @param cause
	 *            Throwable
	 */
	public ModelException(final Throwable cause) {
		super(cause);
	}
}
