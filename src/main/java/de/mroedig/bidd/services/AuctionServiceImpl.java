package de.mroedig.bidd.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.dao.AuctionDao;
import de.mroedig.bidd.dao.BenutzerDao;
import de.mroedig.bidd.entities.Auction;
import de.mroedig.bidd.entities.Gebot;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private BenutzerDao bildDao;

	@Autowired
	private AuctionDao auctionDao;

	@Override
	@Transactional
	public void createNewAuction(Auction neueAuktion) {
		neueAuktion.setStartZeitpunkt(new Date());

		auctionDao.persistiere(neueAuktion);
	}

	@Override
	@Transactional
	public List<? extends Auction> getAllAuctions() {
		return auctionDao.getAll();
	}

	@Override
	@Transactional
	public void erstelleGebot(Gebot pNeuesGebot) {

	}

}
