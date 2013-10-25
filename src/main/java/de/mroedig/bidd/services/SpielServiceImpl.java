package de.mroedig.bidd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.dao.SpielDao;
import de.mroedig.bidd.dao.SpielServerDao;
import de.mroedig.bidd.entities.Spiel;
import de.mroedig.bidd.entities.SpielServer;

@Service
public class SpielServiceImpl implements SpielService {

	@Autowired
	private SpielDao spielDao;

	@Autowired
	private SpielServerDao spielServerDao;

	@Override
	@Transactional
	public void speichereNeuesSpiel(Spiel spiel) {
		spiel.assertValide();
		spielDao.persistiere(spiel);
	}

	@Override
	@Transactional
	public Spiel getSpielByName(String string) {
		return spielDao.findByName(string);
	}

	@Override
	@Transactional
	public void speichereNeuenServerZuSpiel(SpielServer serv) {
		serv.assertValide();
		spielServerDao.persistiere(serv);
	}

	@Override
	@Transactional
	public SpielServer getSpielServerBySpielAndName(Spiel spiel, String string) {

		return spielServerDao.getSpielServerBySpielAndName(
				spielDao.getById(spiel.getIdent()), string);
	}
}
