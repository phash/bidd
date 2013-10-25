package de.mroedig.bidd.utils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.entities.Benutzer;
import de.mroedig.bidd.entities.Role;
import de.mroedig.bidd.services.BenutzerService;

/**
 * Spring-security requires an implementation of UserDetailService.
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {

	/** Die ID zur Serialisierung. */
	private static final long serialVersionUID = -5444103068010017014L;

	/** Die benötigte Benutzerlogik. */
	@Autowired
	private BenutzerService benutzerService; // NOPMD

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String username) {
		final Benutzer gefundenerBenutzer = benutzerService
				.getBenutzerByName(username);

		if (null == gefundenerBenutzer) {
			throw new UsernameNotFoundException("Benutzer \"" + username
					+ "\" im System nicht gefunden!");
		}

		final Set<GrantedAuthority> userAuthorities = new HashSet<GrantedAuthority>();

		for (final Role rolle : gefundenerBenutzer.getRollen()) {

			userAuthorities.add(new SimpleGrantedAuthority(rolle
					.getSpringSecurityRoleName())); // NOPMD

		}

		gefundenerBenutzer.setAuthorities(userAuthorities);

		return gefundenerBenutzer;

	}

}
