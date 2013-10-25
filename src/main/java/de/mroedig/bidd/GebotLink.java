package de.mroedig.bidd;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.mroedig.bidd.entities.Gebot;
import de.mroedig.bidd.services.AuctionService;
import de.mroedig.bidd.services.BenutzerService;

public class GebotLink extends Link<Gebot> {

	private final Integer gebotshoehe;

	@SpringBean
	private BenutzerService benutzerService;

	@SpringBean
	private AuctionService auctionService;

	public GebotLink(String id, IModel<Gebot> model, int gebotshoehe) {
		super(id, model);
		this.gebotshoehe = gebotshoehe;
		Injector.get().inject(this);
	}

	@Override
	public void onClick() {
		SecureWebSession session = (SecureWebSession) getSession();

		if (session.hasRole(benutzerService.getUserRole())) {
			doTransaction();
			return;
		}

		getPage().error("Bitte erst einloggen!");

	}

	private void doTransaction() {
		getModelObject().setGebotsHoehe(gebotshoehe);
		auctionService.erstelleGebot(getModelObject());
	}

}