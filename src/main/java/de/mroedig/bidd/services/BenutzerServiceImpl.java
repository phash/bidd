package de.mroedig.bidd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.mroedig.bidd.dao.BenutzerDao;
import de.mroedig.bidd.dao.RollenDao;
import de.mroedig.bidd.entities.Benutzer;
import de.mroedig.bidd.utils.BidsPasswordEncoder;
import de.mroedig.exceptions.ModelException;

@Service
public class BenutzerServiceImpl implements BenutzerService {

	@Autowired
	private BenutzerDao benutzerDao;

	@Autowired
	private RollenDao rollenDao;

	@Override
	@Transactional
	public Benutzer authenticate(String username, String password) {
		// TODO passwort hashen
		return benutzerDao.findByUserNameAndPassword(username, password);

	}

	@Override
	@Transactional
	public boolean benutzerHasAnyRoles(Benutzer aktuellerBenutzer) {

		Benutzer persBenutzer = benutzerDao.getById(aktuellerBenutzer
				.getIdent());
		if (persBenutzer == null || persBenutzer.getRollen() == null) {
			return false;
		}
		return persBenutzer.getRollen().size() > 0;

	}

	@Override
	public boolean erstelleNeuenBenutzer(Benutzer pBenutzer) {
		Benutzer gefundenerBenutzer = benutzerDao.findByUserName(pBenutzer
				.getBenutzername());
		if (gefundenerBenutzer != null) {
			throw new ModelException(
					"Benutzer mit diesem Namen schon vorhanden");
		}

		Benutzer neuerBenutzer = new Benutzer();
		neuerBenutzer.setBenutzername(pBenutzer.getBenutzername());
		neuerBenutzer.setMail(pBenutzer.getMail());
		neuerBenutzer.setPasswort(pBenutzer.getPasswort());
		if (neuerBenutzer.isValide()) {

			BidsPasswordEncoder encoder = new BidsPasswordEncoder();
			neuerBenutzer.setPasswort(encoder.encodePassword(
					pBenutzer.getPasswort(), pBenutzer.getBenutzername()));
			neuerBenutzer.getRollen().add(rollenDao.getStandardRolle());

			return benutzerDao.persistiere(neuerBenutzer) != null;
		} else {
			throw new ModelException("Benutzerangaben invalide");
		}

	}

	@Override
	public Benutzer getBenutzerByName(String username) {
		return benutzerDao.findByUserName(username);
	}
}
