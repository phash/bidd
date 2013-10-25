package de.mroedig.bidd.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

import de.mroedig.exceptions.ModelException;

/**
 * @author Manuel Rödig
 */
@MappedSuperclass
public abstract class BasisEntity<ID> implements Serializable { // NOPMD by msir

	/**
	 * 
	 */
	private static final long serialVersionUID = 1439518395403054012L;

	// on 12.04.13
	// 12:14
	private final static Logger LOG = Logger.getLogger(BasisEntity.class);

	/**
	 * Ident
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ident", unique = true, nullable = false, columnDefinition = "serial")
	private ID ident;

	/**
	 * version
	 */
	@SuppressWarnings("unused")
	@Version
	@Column(nullable = false, columnDefinition = "int default 0")
	private Long version;

	/**
	 * letzte Violations bei negativer Validierung
	 */
	private transient Set<ConstraintViolation<BasisEntity<ID>>> letzteViolations = Collections
			.emptySet();

	/**
	 * Sichert zu, dass die Entität gemäß den Validierungs-Annotationen valide
	 * ist
	 * 
	 * @throws WahlenRuntimeException
	 *             WahlenRuntimeException
	 */
	public final void assertValide() throws ModelException {

		if (!this.isValide()) {

			for (final ConstraintViolation<BasisEntity<ID>> element : this
					.getLetzteViolations()) {

				LOG.error(element.getInvalidValue() + " "
						+ element.getMessage());
			}
			throw new ModelException("business.entity.nicht_valide");
		}
	}

	/**
	 * Prüft, ob die Entität gemäß den Validierungs-Annotationen valide ist
	 * 
	 * @return Ergebnis der Validierung
	 */
	public boolean isValide() {
		final ValidatorFactory factory = Validation
				.buildDefaultValidatorFactory();
		final javax.validation.Validator validator = factory.getValidator();

		this.setLetzteViolations(validator.validate(this));

		return this.getLetzteViolations().isEmpty();
	}

	public ID getIdent() {
		return ident;
	}

	public void setIdent(final ID ident) {
		this.ident = ident;
	}

	public Set<ConstraintViolation<BasisEntity<ID>>> getLetzteViolations() {
		return letzteViolations;
	}

	public void setLetzteViolations(
			final Set<ConstraintViolation<BasisEntity<ID>>> letzteViolations) {
		this.letzteViolations = letzteViolations;
	}

}
