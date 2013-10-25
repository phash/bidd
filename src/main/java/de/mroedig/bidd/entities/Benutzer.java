package de.mroedig.bidd.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.wicket.util.io.IClusterable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Benutzer extends BasisEntity<Long> implements IClusterable,
		UserDetails, CredentialsContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307732077374637628L;

	@Column(unique = true)
	@NotBlank
	@Length(min = 4)
	private String benutzername;

	@Length(min = 6)
	private String passwort;

	@NotNull
	private Boolean aktiv;

	@Email
	private String mail;

	/** Rollen des Benutzers */
	@Transient
	private Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(); // NOPMD

	@OneToMany
	private Set<Gebot> gebote = new HashSet<Gebot>(32);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "benutzer_role", joinColumns = { @JoinColumn(name = "benutzer_ident", referencedColumnName = "ident") }, inverseJoinColumns = { @JoinColumn(name = "role_ident", referencedColumnName = "ident") })
	private Set<Role> rollen = new HashSet<Role>(4);

	public Set<Role> getRollen() {
		return rollen;
	}

	public void setRollen(Set<Role> rollen) {
		this.rollen = rollen;
	}

	public Benutzer() {
		super();
	}

	public Benutzer(String uid, Set<Role> roles) {
		if (uid == null) {
			throw new IllegalArgumentException("benutzername must be not null");
		}
		if (roles == null) {
			throw new IllegalArgumentException("roles must be not null");
		}
		benutzername = uid;
		rollen = roles;
	}

	public Benutzer(String benutzername, String passwort, String mail) {
		super();
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.mail = mail;
	}

	public Set<Gebot> getGebote() {
		return gebote;
	}

	public void setGebote(Set<Gebot> gebote) {
		this.gebote = gebote;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPassword() {
		return getPasswort();
	}

	@Override
	public String getUsername() {
		return getBenutzername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAktiv();
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAktiv();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isAktiv();
	}

	@Override
	public boolean isEnabled() {
		return isAktiv();
	}

	public Boolean isAktiv() {
		return aktiv;
	}

	public void setAktiv(Boolean aktiv) {
		this.aktiv = aktiv;
	}

}
