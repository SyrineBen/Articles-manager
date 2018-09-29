package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

import java.util.ArrayList;
import java.util.List;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;

/**
 * Cette définit le concept de chercheur.
 * 
 * @author Denis Conan
 */
public class Chercheur {
	/**
	 * nom du chercheur.
	 */
	private String nom;
	/**
	 * prénom du chercheur.
	 */
	private String prenom;
	/**
	 * institution pour lesquelles le chercheur travaille. <br>
	 * Attention: l'association entre institution et chercheur est bidirectionnelle.
	 */
	private List<Institution> institutions;

	/**
	 * construit une instance.
	 * 
	 * @param nom
	 *            le nom du chercheur.
	 * @param prenom
	 *            le prénom du chercheur.
	 */
	public Chercheur(final String nom, final String prenom) {
		if (nom == null || nom.equals("")) {
			throw new IllegalArgumentException("nom null ou vide");
		}
		if (prenom == null || prenom.equals("")) {
			throw new IllegalArgumentException("prénom null ou vide");
		}
		this.nom = nom;
		this.prenom = prenom;
		this.institutions = new ArrayList<>();
		assert invariant();
	}

	/**
	 * vérifie l'invariant de l'objet.
	 * 
	 * @return vrai si l'invariant est vérifié.
	 */
		public boolean invariant() {
			return nom != null && !nom.equals("") && prenom != null && !prenom.equals("") && institutions != null;
		}

	/**
	 * retourne le nom du chercheur.
	 * 
	 * @return le nom.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * retourne le prénom du chercheur.
	 * 
	 * @return le prénom.
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * retourne les institutions du chercheur.
	 * 
	 * @return les institutions.
	 */
	public List<Institution> getInstitutions() {
		return institutions;
	}

	/**
	 * ajoute une institution au chercheur.
	 * 
	 * @param institution
	 *            l'institution à ajouter.
	 * @throws ChercheurTravailleDejaPourInstitution
	 *             le chercheur travaille déjà pour l'institution.
	 */
	public void ajouterInstitution(final Institution institution) throws ChercheurTravailleDejaPourInstitution {
		if (institution == null) {
			throw new IllegalArgumentException("l'institution n'est pas fournie");
		}
		// programmation défensive
		if (institutions.contains(institution)) {
			throw new ChercheurTravailleDejaPourInstitution(
					"le chercheur travaille déjà pour l'institution '" + institution.getNom() + "'");
		}
		institutions.add(institution);
		assert invariant();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Chercheur other = (Chercheur) obj;
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		} else if (!prenom.equals(other.prenom)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer inst = new StringBuffer("");
		for (Institution institution : institutions) {
			inst.append(institution.getNom()).append(" ");
		}
		return "Chercheur [nom=" + nom + ", prenom=" + prenom + ", institutions=" + inst + "]";
	}
}
