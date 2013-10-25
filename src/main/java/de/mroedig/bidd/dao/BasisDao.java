package de.mroedig.bidd.dao;

import java.io.Serializable;
import java.util.List;

import de.mroedig.bidd.entities.BasisEntity;

@SuppressWarnings("rawtypes")
public interface BasisDao<T extends BasisEntity> extends Serializable {

	/**
	 * Speichert ein <strong>nicht</strong> persistentes Objekt in die DB.
	 * 
	 * @param pEinObjekt
	 *            ein Objekt das zu speichernde Objekt T.
	 * @return die ID des persisiterten Objekt.
	 */
	Long persistiere(T pEinObjekt);

	/**
	 * Hole das Objekt mit ...
	 * 
	 * @param pId
	 *            der ID des gesuchten Objekts
	 * @return das gefundene oder {@code null}
	 */
	T getById(Long pId);

	/**
	 * Hole das Objekt mit ...
	 * 
	 * @param pId
	 *            der ID des gesuchten Objekts
	 * @param pFetchliste
	 *            Entitiäten die gefetchted werden müssen
	 * @return das gefundene oder {@code null}
	 */
	T getById(Long pId, String... pFetchliste);

	/**
	 * @return alle Instanzen einer Entität (T).
	 */
	List<T> getAll();

	/**
	 * @return der Typ für diese DAO.
	 */
	Class<T> getDaoClassType();

	/**
	 * Löscht eine Entität aus der DB.
	 * 
	 * @param pEntity
	 *            die zu löschende Entität
	 */
	void loesche(T pEntity);

	/**
	 * eine Funktion sie zu finden, sie alle zu knechten, ins Dunkel zu treiben
	 * und ewig zu binden! Macht aus einem detached Object ein attached Object
	 * 
	 * @param pEntity
	 */
	T merge(T pEntity);

}