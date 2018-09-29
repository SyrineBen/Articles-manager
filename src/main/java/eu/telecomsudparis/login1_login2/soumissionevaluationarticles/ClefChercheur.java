package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

/**
 * Cette classe définit le type servant de clef pour la collection de chercheurs.
 * 
 * @author Denis Conan
 */
public class ClefChercheur {
	/**
	 * le nom du chercheur.
	 */
	private String nom;
	/**
	 * le prénom du chercheur.
	 */
	private String prenom;

	/**
	 * construit une instance.
	 * 
	 * @param nom nom de la clef.
	 * @param prenom prénom de la clef.
	 */
	public ClefChercheur(final String nom, final String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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
		ClefChercheur other = (ClefChercheur) obj;
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
		return "ClefChercheur [nom=" + nom + ", prénom=" + prenom + "]";
	}
}
