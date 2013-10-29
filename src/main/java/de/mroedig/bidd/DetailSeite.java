package de.mroedig.bidd;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;
import org.springframework.beans.factory.annotation.Autowired;

import de.mroedig.bidd.entities.Auction;
import de.mroedig.bidd.services.AuctionService;

public class DetailSeite extends WebPage {

	@SpringBean
	private AuctionService auctionService;

	public DetailSeite(PageParameters parameters) {
		super(parameters);
		Injector.get().inject(this);

		if (parameters.get("ident") != null) {
			
			StringValue name = parameters.get("ident");
			item = auctionService.getAuctionById(name.toLong());

		}
		
		createContent();
	}
	
	

	public DetailSeite() {
		 this(null);
//		super();
//		
//		Injector.get().inject(this);
	}

//	public DetailSeite(Auction auktion) {
//		Injector.get().inject(this);
//		item = auktion;
//		createContent();
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 501269916523526180L;
	private Auction item;

	public Auction getItem() {
		return item;
	}

	public void setItem(Auction item) {
		this.item = item;
	}



	private void createContent() {
		super.onInitialize();
		setStatelessHint(true);
	

		add(new Label("ident", this.getItem().getIdent()));
		add(new Label("auktionsGegenstand", this.getItem()
				.getAuktionsGegenstand()));
		add(new Label("preisInCent", this.getItem().getPreisInCent()));
		add(new Label("waehrung", this.getItem().getWaehrung()));
		add(new Label("startZeitpunkt", this.getItem().getStartZeitpunkt()));
		add(new Label("laufzeitInSekunden", this.getItem()
				.getLaufzeitInSekunden()));
		add(new Label("spiel", this.getItem().getSpiel().getSpielname()));
		add(new Label("spielServer", this.getItem().getSpielServer()
				.getBezeichnung()));
		add(new Label("besitzer", this.getItem().getBesitzer()
				.getBenutzername()));
	}

}
