package de.mroedig.exceptions;

import java.text.MessageFormat;


/**
 * Die Mutter/der Vater aller Exceptions.
 * 
 */
public class BasisException extends Exception {

	/**
	 * Die ID zur Serialisierung.
	 */
	private static final long serialVersionUID = 2714022764451193809L;

	/**
	 * ggf. Fehlermeldung.
	 */
	private final String fehlermeldung; // NOPMD

	/**
	 * ggf. Fehlermeldung.
	 */
	private final Fehler verursachenderFehler; // NOPMD

	/**
	 * Konstruktor mit der entprechenden Fehlermeldung.
	 * 
	 * @param pFehlermeldung
	 *            die Fehlermeldung
	 */
	public BasisException(final String pFehlermeldung) {
		this(Fehler.UNBEKANNTER_FEHLER, pFehlermeldung);
	}

	/**
	 * Konstruktor mit Fehler
	 * 
	 * @param pFehler
	 *            der Fehler
	 * @param params
	 *            ggf Paramter
	 */
	public BasisException(final Fehler pFehler, final Object... params) {
		super();
		verursachenderFehler = pFehler;
		fehlermeldung = MessageFormat.format(
				verursachenderFehler.getFehlermeldung(), params);
	}

	/*------------------------------------------------------------------------
	 * SETTER und GETTER
	 */
	/**
	 * @return die Fehlermeldung
	 */
	public String getFehlermeldung() {
		return fehlermeldung;
	}

	/**
	 * @return the verusachenderFehler
	 */
	public Fehler getVerursachenderFehler() {
		return verursachenderFehler;
	}
}
