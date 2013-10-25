package de.mroedig.bidd;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
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
			protected void populateItem(ListItem<Auction> item) {
				item.add(new Label("ident"));
				item.add(new Label("auktionsGegenstand"));
				item.add(new Label("preisInCent"));
				item.add(new Label("waehrung"));
				item.add(new Label("startZeitpunkt"));
				item.add(new Label("laufzeitInSekunden"));

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
