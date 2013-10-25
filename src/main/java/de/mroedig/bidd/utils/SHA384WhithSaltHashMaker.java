package de.mroedig.bidd.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * erstellt aus String hascode mit dem SH384 Verfahren.
 * 
 */
public class SHA384WhithSaltHashMaker implements StringHashMaker {

	/** der Encoder-Typ. */
	private static final String ENCODER_TYP = "SHA-384";
	/** Singleton: md5 Encoder. */
	private MessageDigest encoder; // NOPMD

	@Override
	public String getStringHash(final String pEinString) {
		final MessageDigest derEncoder = getEncoder();

		encoder.update(pEinString.getBytes());

		return DatatypeConverter.printHexBinary(derEncoder.digest());
	}

	@Override
	public String getStringSaltedHash(final String pEinString,
			final String pSalt) {
		final MessageDigest derEncoder = getEncoder();
		encoder.update(pEinString.getBytes());

		if (pSalt != null) {
			encoder.update(pSalt.getBytes());
		}

		return DatatypeConverter.printHexBinary(derEncoder.digest());
	}

	@Override
	public int getHashSize() {
		return getEncoder().getDigestLength() * 2; // Da als Hex dargestellt
	}

	/*------------------------------------------------------------------------
	 * SETTER und GETTER
	 */

	/**
	 * @return der encoder.
	 */
	private MessageDigest getEncoder() {

		if (encoder == null) {
			try {
				encoder = MessageDigest.getInstance(ENCODER_TYP);
			} catch (final NoSuchAlgorithmException e) {
				throw new RuntimeException("Encoder \"" + ENCODER_TYP
						+ "\" wird nicht unterstüzt."); // NOPMD
			}
		}

		return encoder;
	}
}
