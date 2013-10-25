package de.mroedig.bidd.utils;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Dubiose spezialisierung eines von Spring-sec-framework vorgegebenen Encoders.
 * 
 */
@Service(value = "bidsPasswordEncoder")
public class BidsPasswordEncoder implements PasswordEncoder {

	/** ehemals myVerschlüssler */
	private static final SHA384WhithSaltHashMaker VERSCHLUESSLER = new SHA384WhithSaltHashMaker();

	@Override
	public String encodePassword(final String pRawPass, final Object pSalt) {
		return VERSCHLUESSLER.getStringSaltedHash(pRawPass, (String) pSalt);

	}

	@Override
	public boolean isPasswordValid(final String pEncPass,
			final String pRawPass, final Object pSalt) {
		return pEncPass.equals(encodePassword(pRawPass, pSalt));
	}

}
