package de.mroedig.bidd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.dao.RollenDao;
import de.mroedig.bidd.entities.Auction;
import de.mroedig.bidd.entities.Benutzer;
import de.mroedig.bidd.entities.Role;
import de.mroedig.bidd.entities.Spiel;
import de.mroedig.bidd.entities.SpielServer;

@Service
public class InitServiceImpl implements InitService {

	@Autowired
	private BenutzerService benutzerService;
	@Autowired
	private AuctionService auctionService;

	@Autowired
	private SpielService spielService;

	@Autowired
	private RollenDao rollenDao;

	@Override
	@Transactional
	public void initAll() {

		// createRollen();
		// createUser();
		// createSpiel();
		// createSpielServer();
		// createAuction();

	}

	@Transactional
	private void createAuction() {
		Auction auct = new Auction();
		auct.setBesitzer(benutzerService.getBenutzerByName("klaus"));
		auct.setAuktionsGegenstand("TestGGS");
		auct.setLaufzeitInSekunden(123);
		auct.setWaehrung("GM");
		auct.setPreisInCent(5);
		auct.setSpiel(spielService.getSpielByName("DSO"));
		auct.setSpielServer(spielService.getSpielServerBySpielAndName(
				auct.getSpiel(), "Welt 2"));

		auctionService.createNewAuction(auct);

	}

	@Transactional
	private void createSpielServer() {
		SpielServer serv = new SpielServer();
		serv.setBezeichnung("Welt 2");
		serv.setSpiel(spielService.getSpielByName("DSO"));
		spielService.speichereNeuenServerZuSpiel(serv);

	}

	@Transactional
	private void createSpiel() {
		Spiel spiel = new Spiel();
		spiel.setSpielname("DSO");
		spielService.speichereNeuesSpiel(spiel);
	}

	@Transactional
	private void createUser() {
		Benutzer klaus = new Benutzer("klaus", "qwertz", "heinz@klaus.de");
		benutzerService.erstelleNeuenBenutzer(klaus);

	}

	@Transactional
	private void createRollen() {
		rollenDao.persistiere(new Role("USER"));
		rollenDao.persistiere(new Role("ADMIN"));

	}

}
