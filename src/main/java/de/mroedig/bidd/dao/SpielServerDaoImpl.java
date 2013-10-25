package de.mroedig.bidd.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.mroedig.bidd.entities.Spiel;
import de.mroedig.bidd.entities.SpielServer;

@Repository
public class SpielServerDaoImpl extends BasisDaoImpl<SpielServer> implements
		SpielServerDao {

	@Override
	public SpielServer getSpielServerBySpielAndName(Spiel byId, String string) {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("spiel", byId));
		myCriteria.add(Restrictions.eq("bezeichnung", string));
		return (SpielServer) myCriteria.uniqueResult();
	}
}
