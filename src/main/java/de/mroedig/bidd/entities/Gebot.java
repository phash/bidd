package de.mroedig.bidd.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Gebot extends BasisEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 234599860172028353L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auction_ident")
	private Auction auktion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "benutzer_ident")
	private Benutzer benutzer;

	private Date gebotsZeitpunkt;

	private Integer gebotsHoehe;

	public Auction getAuktion() {
		return auktion;
	}

	public void setAuktion(Auction auktion) {
		this.auktion = auktion;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	public Date getGebotsZeitpunkt() {
		return gebotsZeitpunkt;
	}

	public void setGebotsZeitpunkt(Date gebotsZeitpunkt) {
		this.gebotsZeitpunkt = gebotsZeitpunkt;
	}

	public Integer getGebotsHoehe() {
		return gebotsHoehe;
	}

	public void setGebotsHoehe(Integer gebotsHoehe) {
		this.gebotsHoehe = gebotsHoehe;
	}

}
