package de.mroedig.bidd.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import de.mroedig.bidd.entities.BasisEntity;

/**
 * Basis-Implementierung fÃ¼r Daos.
 * 
 * @param <T>
 *            Entity, auf die sich das DAO bezieht.
 * @param <ID>
 *            Typ des Identifiers der Entity.
 * 
 */

public abstract class BasisDaoImpl<T extends BasisEntity> implements
		BasisDao<T>, Serializable {

	/** Die ID zur Serialisierung. */
	private static final long serialVersionUID = -8345412764989848431L;

	/** SessionFaktorie fÃ¼r alle DAOs. */

	@Resource(name = "sessionFactory", type = SessionFactory.class)
	private SessionFactory mySessionFactory;

	/** T als class (geht scheinbar nicht anders). */
	private Class<T> entityKlasse;

	/**
     */
	@SuppressWarnings("unchecked")
	public BasisDaoImpl() {
		this.entityKlasse = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * @return die zu nutzende HibernateSession.
	 */
	protected Session getMySession() {
		return this.getMySessionFactory().getCurrentSession();
	}

	@Override
	public java.lang.Long persistiere(final T pEinObject) {

		@SuppressWarnings("unchecked")
		final java.lang.Long generierteID = (java.lang.Long) this
				.getMySession().save(pEinObject);

		return generierteID;
	}

	@Override
	public void loesche(final T entity) {
		this.getMySession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(final java.lang.Long pId) {
		return (T) this.getMySession().get(this.entityKlasse, pId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(final java.lang.Long pId, final String... pFetchliste) {
		final Criteria myCrit = this.getNewCriteria();
		myCrit.add(Restrictions.eq("id", pId));

		for (final String element : pFetchliste) {
			myCrit.setFetchMode(element, FetchMode.JOIN);
		}

		return (T) myCrit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return this.getMySession().createCriteria(this.entityKlasse).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(final T pEinObjekt) {
		return (T) this.getMySession().merge(pEinObjekt);
	}

	/*------------------------------------------------------------------------
	 * SETTER und GETTER
	 */

	@Override
	public Class<T> getDaoClassType() {
		return this.entityKlasse;
	}

	/**
	 * @return the entityKlasse
	 */
	public Class<T> getEntityKlasse() {
		return this.entityKlasse;
	}

	/**
	 * @param pEntityKlasse
	 *            the entityKlasse to set
	 */
	public void setEntityKlasse(final Class<T> pEntityKlasse) {
		this.entityKlasse = pEntityKlasse;
	}

	/**
	 * @return ein neues {@link Criteria} fÃ¼r die diese DAO-Entity;
	 */
	protected Criteria getNewCriteria() {
		return this.getMySession().createCriteria(this.getDaoClassType());
	}

	/**
	 * @return the mySessionFactory
	 */
	public SessionFactory getMySessionFactory() {
		return this.mySessionFactory;
	}

	/**
	 * @param pMySessionFactory
	 *            the mySessionFactory to set
	 */
	public void setMySessionFactory(final SessionFactory pMySessionFactory) {
		this.mySessionFactory = pMySessionFactory;
	}

	/**
	 * Liest alle Entities ein.
	 * 
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	protected final Map<Long, T> getEntityMap() {
		final Map<Long, T> result = new HashMap<Long, T>(1024);
		for (final T t : (List<T>) getNewCriteria().list()) {
			result.put((Long) t.getIdent(), t);
		}

		return result;
	}

}