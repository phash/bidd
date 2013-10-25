package de.mroedig.bidd.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.mroedig.bidd.entities.Spiel;

@Repository
public class SpielDaoImpl extends BasisDaoImpl<Spiel> implements SpielDao {

	@Override
	public Spiel findByName(String string) {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("spielname", string));
		return (Spiel) myCriteria.uniqueResult();
	}

}
