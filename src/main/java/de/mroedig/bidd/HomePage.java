package de.mroedig.bidd;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.mroedig.bidd.entities.Auction;
import de.mroedig.bidd.sec.LogoutLink;
import de.mroedig.bidd.services.AuctionService;
import de.mroedig.bidd.services.InitService;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private AuctionService auctionService;

	@SpringBean
	private InitService initService;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		Injector.get().inject(this);
		initService.initAll();

		add(new FeedbackPanel("feedback"));

		add(new LogoutLink("logoutLink"));

		add(new Label("zeigDichN",
				"DAS HIER IST NUR DA, WENN DU NICHT ANGEMELDET BIST") {
			/**
					 * 
					 */
			private static final long serialVersionUID = 9074375551076024958L;

			@Override
			public boolean isVisible() {
				return !((SecureWebSession) getSession()).isSignedIn();
			}
		});
		Model<String> labelModel = Model
				.of("DAS HIER IST NUR DA, WENN DU ANGEMELDET BIST");
		Label msg = new Label("zeigDichA", labelModel) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6394262130538247553L;

			@Override
			public boolean isVisible() {
				return ((SecureWebSession) getSession()).isSignedIn();
			}

		};
		if (msg.isVisible()) {
			labelModel.setObject("HALLO "
					+ ((SecureWebSession) getSession()).getUserName());
		}
		add(msg);
		add(new ListView<Auction>("auctionList",
				auctionService.getAllAuctions()) {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<Auction> item) {
				item.add(new Label("ident"));
				item.add(new Label("auktionsGegenstand"));
				item.add(new Label("preisInCent"));
				item.add(new Label("waehrung"));
				item.add(new Label("startZeitpunkt"));
				item.add(new Label("laufzeitInSekunden"));
				item.add(new Label("spiel", item.getModelObject().getSpiel()
						.getSpielname()));
				item.add(new Label("spielServer", item.getModelObject()
						.getSpielServer().getBezeichnung()));
				item.add(new Label("besitzer", item.getModelObject()
						.getBesitzer().getBenutzername()));

				PageParameters pars = new PageParameters();
				pars.add("ident", item.getModelObject().getIdent());
				item.add(new BookmarkablePageLink<Void>("details",
						DetailSeite.class, pars));

			}

			@Override
			protected ListItem<Auction> newItem(int index,
					IModel<Auction> itemModel) {
				return super.newItem(index, new CompoundPropertyModel<Auction>(
						itemModel));
			}

		});

	}
}
