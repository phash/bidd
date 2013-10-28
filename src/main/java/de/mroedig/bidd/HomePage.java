package de.mroedig.bidd;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.mroedig.bidd.entities.Auction;
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

		add(new Link<Void>("logoutLink") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6050395684254918792L;

			@Override
			public void onClick() {
				getSession().invalidate();
			}

		});

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
				item.add(new BookmarkablePageLink("details", DetailSeite.class, pars));
				             
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
