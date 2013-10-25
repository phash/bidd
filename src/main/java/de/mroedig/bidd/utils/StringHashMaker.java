package de.mroedig.bidd.utils;

/**
 * Erzeugt aus String Hashwerte.
 * 
 */
public interface StringHashMaker {

	/**
	 * gibt dan Übergebenen String "geHashed" zurück.
	 * 
	 * @param pEinString
	 *            der originale String
	 * @return der ermittelte Hash
	 */
	String getStringHash(final String pEinString);

	/**
	 * gibt den Übergebenen String "geHashed" zurück.
	 * 
	 * @param pEinString
	 *            der originale String
	 * @param pSalt
	 *            'Salz' für die Hash-Bildung
	 * @return der ermittelte Hash
	 */
	String getStringSaltedHash(String pEinString, String pSalt);

	/**
	 * @return die Länge in bytes, der hashes die ezeugt werden.
	 */
	int getHashSize();

}
