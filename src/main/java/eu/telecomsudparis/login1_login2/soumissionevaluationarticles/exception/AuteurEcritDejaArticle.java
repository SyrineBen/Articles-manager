package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception;

import eu.telecomsudparis.csc4102.util.OperationImpossible;


	public class AuteurEcritDejaArticle extends OperationImpossible {
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
		public AuteurEcritDejaArticle(final String message) {
			super(message);
		}
	

}
