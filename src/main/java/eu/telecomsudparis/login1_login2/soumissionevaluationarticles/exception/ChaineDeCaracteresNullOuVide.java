package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le type d'exception pour une chaîne de caractères non
 * valide&nbsp;: null ou vide.
 * 
 * @author Denis Conan
 */
public class ChaineDeCaracteresNullOuVide extends OperationImpossible {
	/**
	 * numéro de version pour la sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * construit une instance.
	 * 
	 * @param message
	 *            le message de l'exception.
	 */
	public ChaineDeCaracteresNullOuVide(final String message) {
		super(message);
	}
}
