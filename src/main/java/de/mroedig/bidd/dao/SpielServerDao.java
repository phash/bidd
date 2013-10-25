package de.mroedig.bidd.dao;

import de.mroedig.bidd.entities.Spiel;
import de.mroedig.bidd.entities.SpielServer;

public interface SpielServerDao extends BasisDao<SpielServer> {

	SpielServer getSpielServerBySpielAndName(Spiel byId, String string);

}
