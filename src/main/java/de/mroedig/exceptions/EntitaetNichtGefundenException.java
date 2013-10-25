package de.mroedig.exceptions;


/**
 * Eine Entität konnte nicht in der DB Gefunden werden
 * 
 */
public class EntitaetNichtGefundenException extends BasisException {

	/**
	 * Die ID zur Serialisierung.
	 */
	private static final long serialVersionUID = 663780383426830712L;

	/**
	 * naja.
	 */
	public EntitaetNichtGefundenException() {
		super(Fehler.ALLGEMEINER_ENTITY_NICHT_GEFUNDEN_FEHLER);
	}

	/**
	 * mit Fehlermeldung.
	 * 
	 * @param pFehlermeldung
	 *            die relevante Fehlermledung.
	 */
	@Deprecated
	public EntitaetNichtGefundenException(final String pFehlermeldung) {
		super(pFehlermeldung);
	}

	/**
	 * Konstruktor mit Fehler
	 * 
	 * @param pFehler
	 *            der Fehler
	 * @param params
	 *            ggf Paramter
	 */
	public EntitaetNichtGefundenException(final Fehler pFehler,
			final Object... params) {
		super(pFehler, params);
	}
}
