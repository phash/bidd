package de.mroedig.bidd.services;

import de.mroedig.bidd.entities.Benutzer;
import de.mroedig.bidd.entities.Role;

public interface BenutzerService {

	Benutzer authenticate(String username, String password);

	boolean benutzerHasAnyRoles(Benutzer aktuellerBenutzer);

	boolean erstelleNeuenBenutzer(Benutzer neuerNutzer);

	Benutzer getBenutzerByName(String string);

	Role getUserRole();

}
