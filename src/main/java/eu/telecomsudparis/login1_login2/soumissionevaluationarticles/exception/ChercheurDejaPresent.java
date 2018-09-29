package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le type d'exception pour un chercheur (auteur ou
 * éditeur) déjà présent.
 * 
 * @author Denis Conan
 */
public class ChercheurDejaPresent extends OperationImpossible {
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
	public ChercheurDejaPresent(final String message) {
		super(message);
	}
}
