package de.mroedig.bidd.services;

import de.mroedig.bidd.entities.Benutzer;

public interface BenutzerService {

	Benutzer authenticate(String username, String password);

	boolean benutzerHasAnyRoles(Benutzer aktuellerBenutzer);

	boolean erstelleNeuenBenutzer(Benutzer neuerNutzer);

	Benutzer getBenutzerByName(String string);

}
