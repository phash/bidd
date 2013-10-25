package de.mroedig.bidd.services;

import java.util.List;

import de.mroedig.bidd.entities.Auction;
import de.mroedig.bidd.entities.Gebot;

public interface AuctionService {

	void createNewAuction(Auction neueAuktion);

	List<? extends Auction> getAllAuctions();

	void erstelleGebot(Gebot gebot);

}
