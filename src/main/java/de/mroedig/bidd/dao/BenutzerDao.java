package de.mroedig.bidd.dao;

import de.mroedig.bidd.entities.Benutzer;

public interface BenutzerDao extends BasisDao<Benutzer> {

	Benutzer findByUserNameAndPassword(String username, String password);

	Benutzer findByUserName(String username);

	void flushMe();

}
