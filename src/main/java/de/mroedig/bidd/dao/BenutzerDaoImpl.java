package de.mroedig.bidd.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.mroedig.bidd.entities.Benutzer;

@Repository(value = "benutzerDao")
public class BenutzerDaoImpl extends BasisDaoImpl<Benutzer> implements
		BenutzerDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 827163382674959810L;

	@Override
	public Benutzer findByUserNameAndPassword(String username, String password) {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("benutzername", username));
		myCriteria.add(Restrictions.eq("passwort", password));

		return (Benutzer) myCriteria.uniqueResult();
	}

	@Override
	public Benutzer findByUserName(String username) {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("benutzername", username));

		return (Benutzer) myCriteria.uniqueResult();
	}

}
