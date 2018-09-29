package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.interfaceutilisateur;

import eu.telecomsudparis.csc4102.util.Console;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Chercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
/**
 * Cette classe définit le menu d'utilisation de l'application.
 */
public final class InterfaceTextuelle {

	/**
	 * Reference sur l'instance.
	 */
	private static ToSPy toSPy = null;

	/**
	 * constructeur privée pour classe main.
	 */
	private InterfaceTextuelle() {
	}

	/**
	 * fonction main.
	 * 
	 * @param args
	 *            argument de la ligne de commande.
	 * @throws ChercheurDejaPresent 
	 */
	public static void main(final String[] args) throws ChercheurDejaPresent {
		toSPy = new ToSPy();
		try {

			int choix;
			while ((choix = menu()) > 0) {
				switch (choix) {
				case 1:
					chercherChercheur();
					break;
				case 2:
					ajouterChercheur("ghailene","souissi");
					break;
				case 3 :
					
					break;
				default:
					break;
				}
			}
		} catch (IllegalArgumentException | ChaineDeCaracteresNullOuVide | ChercheurInexistant ex) {
			System.out.println("Erreur Menu : " + ex);
		}
	}

	/**
	 * chercher un chercheur.
	 * 
	 * @throws ChaineDeCaracteresNullOuVide
	 *             chaîne de caracteres null ou vide.
	 * @throws ChercheurInexistant
	 *             chercheur inexistant.
	 */
	private static void chercherChercheur() throws ChaineDeCaracteresNullOuVide, ChercheurInexistant {
		String nom = Console.readLine(" Nom du chercheur :");
		String prenom = Console.readLine(" Prénom du chercheur :");
		Chercheur chercheur = toSPy.chercherChercheur(nom, prenom);
		System.out.println(chercheur);
	}
	private static void ajouterChercheur(String nom,String prenom) throws ChaineDeCaracteresNullOuVide, ChercheurDejaPresent{
		
		toSPy.ajouterChercheur(nom, prenom);
		System.out.println("Chercheur ajouté"+" "+nom+" "+prenom);
		
	}
	
	/**
	 * Affichage d'un menu.
	 * 
	 * @return code du menu (0 ==> quit)
	 */
	static int menu() {
		System.out.println("\n" + ": Menu");
		System.out.println("  1- chercherChercheur");
		System.out.println("  2- ajouterChercheur");
		System.out.println("  0- quitter");
		int choix = 0;
		try {
			choix = Console.readInt("\nEntrer le choix :");
		} catch (Exception e) {
			System.err.println("Erreur de saisie");
		}
		return choix;
	}
}
