package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception;

import eu.telecomsudparis.csc4102.util.OperationImpossible;

/**
 * Cette classe définit le type d'exception pour un article inexistante.
 * 
 * @author Ghailene Souissi
 */
public class ArticleInexistant extends OperationImpossible {
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
	public ArticleInexistant(final String message) {
		super(message);
	}

}
