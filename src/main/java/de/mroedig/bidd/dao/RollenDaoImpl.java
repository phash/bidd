package de.mroedig.bidd.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.mroedig.bidd.entities.Role;

@Repository
public class RollenDaoImpl extends BasisDaoImpl<Role> implements RollenDao {

	@Override
	public Role getStandardRolle() {
		Criteria myCriteria = getNewCriteria();
		myCriteria.add(Restrictions.eq("springSecurityRoleName", "USER"));
		return (Role) myCriteria.uniqueResult();
	}
}
