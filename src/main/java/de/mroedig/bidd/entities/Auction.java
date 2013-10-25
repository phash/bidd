package de.mroedig.bidd.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Auction extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2094661481418245052L;
	private String auktionsGegenstand;
	private Integer preisInCent;
	private Integer laufzeitInSekunden;
	private Date startZeitpunkt;
	private String waehrung;
	private String beschreibung;

	private Spiel spiel;
	private SpielServer spielServer;

	@ManyToOne
	private Benutzer besitzer;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auktion")
	private Set<Gebot> gebote;

	public Benutzer getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Benutzer besitzer) {
		this.besitzer = besitzer;
	}

	public Set<Gebot> getGebote() {
		return gebote;
	}

	public void setGebote(Set<Gebot> gebote) {
		this.gebote = gebote;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public String getAuktionsGegenstand() {
		return auktionsGegenstand;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public void setAuktionsGegenstand(String auktionsGegenstand) {
		this.auktionsGegenstand = auktionsGegenstand;
	}

	public Integer getPreisInCent() {
		return preisInCent;
	}

	public void setPreisInCent(Integer preisInCent) {
		this.preisInCent = preisInCent;
	}

	public Integer getLaufzeitInSekunden() {
		return laufzeitInSekunden;
	}

	public void setLaufzeitInSekunden(Integer laufzeitInSekunden) {
		this.laufzeitInSekunden = laufzeitInSekunden;
	}

	public Date getStartZeitpunkt() {
		return startZeitpunkt;
	}

	public Spiel getSpiel() {
		return spiel;
	}

	public void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	public SpielServer getSpielServer() {
		return spielServer;
	}

	public void setSpielServer(SpielServer spielServer) {
		this.spielServer = spielServer;
	}

	public void setStartZeitpunkt(Date startZeitpunkt) {
		this.startZeitpunkt = startZeitpunkt;
	}

}
