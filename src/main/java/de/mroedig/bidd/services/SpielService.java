package de.mroedig.bidd.services;

import de.mroedig.bidd.entities.Spiel;
import de.mroedig.bidd.entities.SpielServer;

public interface SpielService {

	void speichereNeuesSpiel(Spiel spiel);

	Spiel getSpielByName(String string);

	void speichereNeuenServerZuSpiel(SpielServer serv);

	SpielServer getSpielServerBySpielAndName(Spiel spiel, String string);

}
