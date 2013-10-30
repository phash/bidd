package de.mroedig.bidd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import de.mroedig.bidd.entities.Benutzer;
import de.mroedig.bidd.entities.Role;
import de.mroedig.bidd.services.BenutzerService;

public class SecureWebSession extends AuthenticatedWebSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047035309585291875L;

	private static Logger logger = Logger.getLogger(SecureWebSession.class);

	private final HttpSession httpSession;

	@SpringBean(name = "authenticationManager")
	private AuthenticationManager authenticationManager;

	@SpringBean
	private BenutzerService benutzerService;

	private Benutzer angemeldeterBenutzer;

	public SecureWebSession(Request request) {
		super(request);
		httpSession = ((HttpServletRequest) request.getContainerRequest())
				.getSession();
		Injector.get().inject(this);
	}

	@Override
	public boolean authenticate(String username, String password) {
		boolean authenticated = false;
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			SecurityContextHolder.getContext()
					.setAuthentication(authentication);
			authenticated = authentication.isAuthenticated();

			if (authenticated) {
				angemeldeterBenutzer = benutzerService
						.getBenutzerByName(username);
			}
		} catch (AuthenticationException e) {
			logger.warn(String.format("User '%s' failed to login. Reason: %s",
					username, e.getMessage()));
			authenticated = false;
		}

		return authenticated;

	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		if (isSignedIn()) {
			Authentication authentication = SecurityContextHolder.getContext()
					.getAuthentication();
			addRolesFromAuthentication(roles, authentication);
		}
		return roles;
	}

	private void addRolesFromAuthentication(Roles roles,
			Authentication authentication) {
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			roles.add(authority.getAuthority());
		}
	}

	public boolean hasRole(Role role) {
		return getRoles().hasRole(role.getSpringSecurityRoleName());
	}

	public String getUserName() {
		return angemeldeterBenutzer.getBenutzername();
	}
}
