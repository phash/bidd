package de.mroedig.bidd.dao;

import de.mroedig.bidd.entities.Spiel;

public interface SpielDao extends BasisDao<Spiel> {

	Spiel findByName(String string);

}
