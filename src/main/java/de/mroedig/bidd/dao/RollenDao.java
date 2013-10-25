package de.mroedig.bidd.dao;

import de.mroedig.bidd.entities.Role;

public interface RollenDao extends BasisDao<Role> {

	Role getStandardRolle();

}
