package de.mroedig.exceptions;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Fehler
 */
public enum Fehler {

	/**
	 * Fehlermeldung für den JUNIT-Test
	 */
	TEST_FEHLERMEDLUNG,
	/**
	 * Fehlermeldung für den JUNIT-Terst ohne Meldung im Bundle
	 */
	TEST_FEHLERMEDLUNG_OHNE_MELDUNG,
	/**
	 * schade
	 */
	UNBEKANNTER_FEHLER,
	/**
	 * Anmeldung fehgeschlagen
	 */
	ALLGEMEINER_ANMELDEFEHLER,
	/**
	 * Entity not found
	 */
	ALLGEMEINER_ENTITY_NICHT_GEFUNDEN_FEHLER,
	/**
	 * Entity not found -- Meldung
	 */
	ENTITY_NICHT_GEFUNDEN_MIT_MELDUNG,
	/**
	 * Entity not valid -- Meldung
	 */
	ENTITY_NICHT_VALIDE_MIT_MELDUNG,
	/**
	 * Property not found
	 */
	ALLGEMEINER_PROPERTY_NICHT_GEFUNDEN_FEHLER,
	/**
	 * Property not found -- Meldung
	 */
	PROPERTY_NICHT_GEFUNDEN_MIT_MELDUNG,
	/**
	 * Property not changeable
	 */
	ALLGEMEINER_PROPERTY_NICHT_AENDERBAR_FEHLER,
	/**
	 * Property not changeable -- Meldung
	 */
	PROPERTY_NICHT_AENDERBAR_MIT_MELDUNG,
	/**
	 * Wert entspricht nicht dem PropertyTyp
	 */
	ALLGEMEINER_PROPERTYWERT_ENTSPRICHT_NICHT_PROPERTYTYP_FEHLER,
	/**
	 * Wert entspricht nicht dem PropertyTyp -- Meldung
	 */
	PROPERTYWERT_ENTSPRICHT_NICHT_PROPERTYTYP_MIT_MELDUNG,
	// ----------- benutzerverwaltung -----------
	/**
	 * Benutzer beim schon im System vorhanden
	 */
	BENUTZER_SCHON_IM_SYSTEM,
	/**
	 * Illegale Benutzernamen Änderung
	 */
	ILLEGALE_BENUTZERNAMENAENDERUNG,
	/**
	 * Illegale Passwort Änderung
	 */
	ILLEGALE_PASSWORTAENDERUNG,
	/**
	 * Illegale Benutzer-Aktiv Änderung
	 */
	ILLEGALE_BENUTZERAKTIVAENDERUNG,
	/**
	 * Illegale Änderung des Layouts
	 */
	ILLEGALE_LAYOUTAENDERUNG,
	/**
	 * Falsche Passwort/Benutzer - Kombi
	 */
	ANMELDE_FEHLER_BENUTZER_PASSWORT_FALSCH,
	/**
	 * Ivalides Objekt
	 */
	OBJEKT_NICHT_VALIDE,
	// ----------- UTILS für Date -----------

	/**
	 * Datum nicht in der Zuikunft
	 */
	DATUM_NICHT_IN_DER_ZUKUNFT,
	// --------------------------------------------

	// ----------- Personalstundenlogik -----------
	/**
	 * Datum nicht nach Letztem PersonalstundenSatz
	 */
	DATUM_NICHT_NACH_LETZTEN_PERSONALSTUNDENSATZ,
	/**
	 * Preis zu klein
	 */
	PREIS_KLEINER_NULL,
	/**
	 * Passwort nicht richtig
	 */
	PASSWORT_NICHT_KORREKT,
	/**
	 * Passwort nicht gesetzt
	 */
	PASSWORT_NICHT_GESETZT,
	/**
	 * Passwörter nicht gleich
	 */
	PASSWORT_NICHT_GLEICH_DER_WIEDERHOHLUNG,
	/**
	 * Passwort nicht wirklich geändert
	 */
	PASSWORT_NEU_GLEICH_PASSWORT_ALT,
	/**
	 * Aktion bei abgeschlossenen Auftrag
	 */
	AUFTRAG_IST_SCHON_ABGESCHLOSSEN,
	/**
	 * Aktion bei stornierten Auftrag
	 */
	AUFTRAG_IST_STORNIERT,
	/**
	 * Aktion bei storno
	 */
	AUFTRAG_IST_NICHT_ABGESCHLOSSEN,
	// ----------- AufragsKategorie-----------
	/**
	 * Auftrags-Kategorie-Bezeichnungs schon vorhanden
	 */
	AUFTRAGSKATGORIE_BEZEICHNUNG_SCHON_VORHANDEN,
	/**
	 * Auftrags-Kategorie einem Auftragsteil zugeortnet
	 */
	AUFTRAGSKATGORIE_EINEM_AUFTRAGSTEIL_ZUGEORDNET,
	// ----------- AuftragsTeil -----------
	/**
	 * AT ohne Personalkosten
	 */
	AUFTRAGSTEIL_HAT_KEINE_PERSONALKOSTEN,
	/**
	 * AT ohne Personalkosten
	 */
	AUFTRAGSTEIL_BEZEICHNUNG_IM_AUFTRAG_DOPPELT,
	// ----------- FestpreiskostenArt -----------
	/**
	 * FestpreiskostenArt mit bestimmter Bezeichnung schon im System
	 */
	FESTPREISKOSTENART_SCHON_IM_SYSTEM,
	/**
	 * FestpreiskostenArt wird verwendet und ist deswegen nicht löschbar
	 */
	FESTPREISKOSTENART_WIRD_VERWENDET,
	/**
	 * FestpreiskostenArt ist nicht deaktivierbar
	 */
	FESTPREISKOSTENART_NICHT_DEAKTIVIERBAR,
	/**
	 * Datum nicht nach Letztem FestpreiskostenPreis
	 */
	DATUM_NICHT_NACH_LETZTEN_FESTPREISKOSTENPREIS,
	/**
	 * Die Entity ist schon vorhanden
	 */
	ALLGEMEINER_ENTITY_SCHON_VORHANDEN_FEHLER,
	// ----------- Sachkosten -----------
	/**
	 * Die Sachkosten sind nicht vorhanden
	 */
	AUFTRAGSTEIL_HAT_KEINE_SACHKOSTEN,
	// ----------- Sachkosten -----------
	/**
	 * Die Sachkosten sind nicht vorhanden
	 */
	SEITEN_MODUS_FALSCH,
	// ----------- Konvertierung -----------
	/**
	 * Konvertierungsfehler
	 */
	KONVERTIERUNGSFEHLER,
	// ----------- Koordinierung -----------
	/**
	 * Koordinierungsfehler
	 */
	FREMDKOORDINIERUNG_SCHON_VORHANDEN,
	/**
	 * Koordinierungsfehler
	 */
	BAYRISCHE_KOORDINIERUNG_SCHON_VORHANDEN,
	// ----------- Berechner -----------
	/**
	 * kein Auftragsteil beim Auftrag vorhanden obwohl vom Berrechner benötigt
	 */
	KEIN_AUFTRAGSTEIL_VORHANDEN,
	/**
	 * Die Einordnung des Kunden als juristische Person passt nicht zur
	 * Kundenkategorie
	 */
	JURISTISCHER_PERSONEN_FEHLER,
	/**
	 * die Kundenkategorie ist schon einem Auftragsteil zugeordnet
	 */
	KUNDENKATGORIE_EINEM_AUFTRAGSTEIL_ZUGEORDNET,
	// ----------- Plausi -----------------
	/**
	 * Kunde wurde keine Kundenkategorie zugewiesen
	 */
	KUNDE_OHNE_KUNDENKATEGORIE,
	/**
	 * Die Partnerstelle wird bereits verwendet - und kann nicht gelöscht werden
	 */
	PARTNERSTELLE_WIRD_VERWENDET,
	/**
	 * Eine Partnerstelle mit dieser Bezeichnung ist bereits vorhanden
	 */
	PARTNERSTELLE_BEZEICHNUNG_SCHON_VORHANDEN,
	/**
	 * Eine Partnerstelle darf nur eins von beiden sein
	 */
	PARTNERSTELLE_DARF_NICHT_LAND_UND_AMT_SEIN,
	/**
	 * Eine Partnerstelle darf nur eins von beiden sein
	 */
	PARTNERSTELLE_MUSS_ENTWEDER_LAND_ODER_AMT_SEIN,
	/**
	 * Die Berechtigung zur Änderung fehlt
	 */
	BERECHTIGUNG_FEHLT;

	/**
	 * @return die Fehlermeldung
	 */
	public String getFehlermeldung() {

		try {
			final ResourceBundle bundle = ResourceBundle.getBundle(
					"fehlermeldungen", new Locale("de"));
			return bundle.getString(toString());
		} catch (final MissingResourceException e) {
			// log.warn("Fehler <"
			// + toString()
			// + "> Fehlermeldung in der Fehlermeldungsdatei nicht gefunden!");
			return "Fehler <"
					+ toString()
					+ "> Fehlermeldung in der Fehlermeldungsdatei nicht gefunden!";
		}
	}
}
