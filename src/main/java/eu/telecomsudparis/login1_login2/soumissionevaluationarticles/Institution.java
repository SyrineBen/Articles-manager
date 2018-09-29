package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

import java.util.HashMap;
import java.util.Map;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;

/**
 * Cette classe définit le concept métier d'institution de recherche
 * (université, centre de recherche, etc.
 * 
 * @author Denis Conan
 */
public class Institution {
	/**
	 * nom de l'institution considéré comme unique.
	 */
	private String nom;
	/**
	 * adresse de l'institution.
	 */
	private String adresse;
	/**
	 * les chercheurs d'une institution. La clef du dictionnaire est le code du
	 * chercheur et l'objet une instance de chercheur. <br>
	 * Attention: l'association entre institution et chercheur est bidirectionnelle.
	 */
	private Map<ClefChercheur, Chercheur> chercheurs;

	/**
	 * construit une instance.
	 * 
	 * @param nom
	 *            le nom de l'institution.
	 * @param adresse
	 *            l'adresse de l'institution.
	 */
	public Institution(final String nom, final String adresse) {
		if (nom == null || nom.equals("")) {
			throw new IllegalArgumentException("nom null ou vide");
		}
		if (adresse == null || adresse.equals("")) {
			throw new IllegalArgumentException("adresse null ou vide");
		}
		this.nom = nom;
		this.adresse = adresse;
		this.chercheurs = new HashMap<>();
	}

	/**
	 * vérifie l'invariant de l'objet.
	 * 
	 * @return vrai si l'invariant est vérifié.
	 */
	public boolean invariant() {
		return nom != null && !nom.equals("") && adresse != null && !adresse.equals("") && chercheurs != null;
	}

	/**
	 * retourne le nom de l'institution.
	 * 
	 * @return le nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * retourne l'adresse de l'institution.
	 * 
	 * @return l'adresse.
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * retourne la collection des chercheurs.
	 * 
	 * @return la collection des chercheurs.
	 */
	public Map<ClefChercheur, Chercheur> getChercheurs() {
		return chercheurs;
	}

	/**
	 * ajoute un chercheur. C'est dans cette méthode que les vérifications de
	 * non-inclusion sont effectuées et qu'est réalisée l'aspect bi-directionnel de
	 * l'association entre institution et chercheur.
	 * 
	 * @param chercheur
	 *            le chercheur à ajouter.
	 * @throws ChercheurTravailleDejaPourInstitution
	 *             le chercheur travaille déjà pour l'institution.
	 */
	public void ajouterChercheur(final Chercheur chercheur) throws ChercheurTravailleDejaPourInstitution {
		if (chercheur == null) {
			throw new IllegalArgumentException("aucun chercheur n'est fourni");
		}
		ClefChercheur clef = new ClefChercheur(chercheur.getNom(), chercheur.getPrenom());
		if (chercheurs.containsKey(clef)) {
			throw new ChercheurTravailleDejaPourInstitution("le chercheur travaille déjà pour l'institution");
		} else {
			if (chercheur.getInstitutions().contains(this)) {
				throw new ChercheurTravailleDejaPourInstitution("le chercheur travaille déjà pour l'institution");
			} else {
				chercheurs.put(clef, chercheur);
				chercheur.ajouterInstitution(this);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Institution other = (Institution) obj;
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer cher = new StringBuffer("");
		for (Chercheur chercheur : chercheurs.values()) {
			cher.append(chercheur.getNom()).append(" ").append(chercheur.getPrenom()).append(" ");
		}
		return "Institution [nom=" + nom + ", adresse=" + adresse + ", chercheurs=" + cher + "]";
	}
}
