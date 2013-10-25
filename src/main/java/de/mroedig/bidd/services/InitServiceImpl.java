package de.mroedig.bidd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.dao.RollenDao;

@Service
public class InitServiceImpl implements InitService {

	@Autowired
	private BenutzerService benutzerService;
	@Autowired
	private AuctionService auctionService;

	@Autowired
	private RollenDao rollenDao;

	@Override
	@Transactional
	public void initAll() {

		// rollenDao.persistiere(new Role("USER"));
		// rollenDao.persistiere(new Role("ADMIN"));
		//
		// Benutzer klaus = new Benutzer("klaus", "qwertz", "heinz@klaus.de");
		// benutzerService.erstelleNeuenBenutzer(klaus);

		// Auction auct = new Auction();
		// auct.setBesitzer(benutzerService.getBenutzerByName("testBenutzer"));
		// auct.setAuktionsGegenstand("TestGGS");
		// auct.setLaufzeitInSekunden(123);
		// auct.setWaehrung("GM");
		// auct.setPreisInCent(5);
		//
		// auctionService.createNewAuction(auct);

	}

}
