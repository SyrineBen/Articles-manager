package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.InstitutionDejaPresente;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.InstitutionInexistante;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaSoumis;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurInterdit;
/**
 * Cette classe définit la façade du système.
 * 
 * @author Denis Conan
 */
public class ToSPy {
	/**
	 * collection de chercheurs.
	 */
	private Map<ClefChercheur, Chercheur> chercheurs;
	/**
	 * collection d'institutions.
	 */
	private List<Institution> institutions;
	private List<Article> articles;
	private Auteur Correspondant;

	/**
	 * construit la façade.
	 */
	public ToSPy() {
		chercheurs = new HashMap<>();
		institutions = new ArrayList<>();
		articles = new ArrayList<>();
	}

	/**
	 * ajoute une institution au système.
	 * 
	 * @param nom
	 *            le nom de l'institution.
	 * @param adresse
	 *            l'adresse de l'institution.
	 * @throws ChaineDeCaracteresNullOuVide
	 *             mauvais arguments.
	 * @throws InstitutionDejaPresente
	 *             institution déjà présente avec ce nom.
	 */
	public void ajouterInstitution(final String nom, final String adresse)
			throws ChaineDeCaracteresNullOuVide, InstitutionDejaPresente {
		if (nom == null || nom.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom null ou vide non autorisé");
		}
		if (adresse == null || adresse.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("adresse null ou vide non autorisée");
		}
		if (institutions.contains(new Institution(nom, "factice"))) {
			throw new InstitutionDejaPresente("institution '" + nom + "' déjà dans la collection");
		}
		institutions.add(new Institution(nom, adresse));
	}

	/**
	 * retire une institution du système.
	 * 
	 * @param nom
	 *            nom de l'institution à retirer.
	 */
	public void retirerInstitution(final String nom) {
		throw new UnsupportedOperationException();
	}
	
	public void ajouterArticle(final Long id , final Auteur Correspondant)
			throws ChaineDeCaracteresNullOuVide, ArticleDejaPresent {
		if (Correspondant== null ) {
			throw new ChaineDeCaracteresNullOuVide("Correspondant null ou vide non autorisé");
		}
		if (id == null || id.equals((long) 0)) {
			throw new ChaineDeCaracteresNullOuVide("Id null ou vide non autorisée");
		}
		if (articles.contains(new Article(id,Correspondant))) {
			throw new ArticleDejaPresent("l'artice de l'id'" + id + "' déjà dans la collection");
		}
		articles.add(new Article(id, Correspondant));
	}
	public void retirerArticle(final Long id) {
		throw new UnsupportedOperationException();
	}

	/**
	 * ajoute un chercheur au système.
	 * 
	 * @param nom
	 *            le nom du chercheur.
	 * @param prenom
	 *            le prénom du chercheur.
	 * @throws ChaineDeCaracteresNullOuVide
	 *             mauvais arguments.
	 * @throws ChercheurDejaPresent
	 *             chercheur déjà présent avec ce nom et ce prénom (comme auteur ou
	 *             comme éditeur).
	 */
	public void ajouterChercheur(final String nom, final String prenom)
			throws ChaineDeCaracteresNullOuVide, ChercheurDejaPresent {
		if (nom == null || nom.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom null ou vide non autorisé");
		}
		if (prenom == null || prenom.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("prénom null ou vide non autorisé");
		}
		if (chercheurs.containsKey(new ClefChercheur(nom, prenom))) {
			throw new ChercheurDejaPresent("chercheur '" + nom + " " + prenom + "' déjà dans la collection");
		}
		chercheurs.put(new ClefChercheur(nom, prenom), new Chercheur(nom, prenom));
	}

	/**
	 * recherche un chercheur.
	 * 
	 * @param nom
	 *            le nom du chercheur recherché.
	 * @param prenom
	 *            le prénom du chercheur recherché.
	 * @return le chercheur trouvé.
	 * @throws ChaineDeCaracteresNullOuVide
	 *             mauvais arguments.
	 * @throws ChercheurInexistant
	 *             chercheur non présent.
	 */
	public Chercheur chercherChercheur(final String nom, final String prenom)
			throws ChaineDeCaracteresNullOuVide, ChercheurInexistant {
		if (nom == null || nom.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom null ou vide non autorisé");
		}
		if (prenom == null || prenom.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("prénom null ou vide non autorisé");
		}
		if (!chercheurs.containsKey(new ClefChercheur(nom, prenom))) {
			throw new ChercheurInexistant("chercheur '" + nom + " " + prenom + "' inexistant");
		}
		return chercheurs.get(new ClefChercheur(nom, prenom));
	}
	

	/**
	 * retire un chercheur du système.
	 * 
	 * @param nom
	 *            le nom du chercheur.
	 * @param prenom
	 *            le prénom du chercheur.
	 */
	public void retirerChercheur(final String nom, final String prenom) {
		throw new UnsupportedOperationException();
	}

	/**
	 * liste les chercheurs.
	 */
	public void listerChercheurs() {
		System.out.println("Collection des chercheurs :" + chercheurs);
	}

	/**
	 * déclare qu'un chercheur travaille pour une institution.
	 * 
	 * @param nomChercheur
	 *            nom du chercheur.
	 * @param prenomChercheur
	 *            prénom du chercheur.
	 * @param nomInstitution
	 *            nom de l'institution.
	 * @throws ChaineDeCaracteresNullOuVide
	 *             mauvais arguments.
	 * @throws InstitutionInexistante
	 *             l'institution n'existe pas.
	 * @throws ChercheurInexistant
	 *             chercheur n'existant pas.
	 * @throws ChercheurTravailleDejaPourInstitution
	 *             le chercheur travaille déjà pour l'institution.
	 */
	public void ajouterChercheurAInstitution(final String nomChercheur, final String prenomChercheur,
			final String nomInstitution) throws ChaineDeCaracteresNullOuVide, InstitutionInexistante,
			ChercheurInexistant, ChercheurTravailleDejaPourInstitution {
		if (nomChercheur == null || nomChercheur.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom de chercheur null ou vide");
		}
		if (prenomChercheur == null || prenomChercheur.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("prénom de chercheur null ou vide");
		}
		if (nomInstitution == null || nomInstitution.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom de l'institution null ou vide");
		}
		int index = institutions.indexOf(new Institution(nomInstitution, "factice"));
		Chercheur chercheur = chercheurs.get(new ClefChercheur(nomChercheur, prenomChercheur));
		if (index < 0) {
			throw new InstitutionInexistante("l'institution '" + nomInstitution + "' n'existe pas");
		} else {
			if (chercheur == null) {
				throw new ChercheurInexistant(
						"le chercheur '" + nomChercheur + " " + prenomChercheur + "'n'existe pas");
			} else {
				institutions.get(index).ajouterChercheur(chercheur);
			}
		}
	}
	
	public void ajouterAuteur_a_Article(final String nomAuteur, final String prenomAuteur,
			final Long id_article) throws ChaineDeCaracteresNullOuVide, ArticleInexistant,
			ChercheurInexistant, AuteurEcritDejaArticle, ArticleDejaSoumis {
		if (nomAuteur == null || nomAuteur.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("nom de chercheur null ou vide");
		}
		if (prenomAuteur == null || prenomAuteur.equals("")) {
			throw new ChaineDeCaracteresNullOuVide("prénom de chercheur null ou vide");
		}
		if (id_article == null || id_article==(long)0) {
			throw new ChaineDeCaracteresNullOuVide("id de l'article null ou égale à 0");
		}
		Article article= new Article(id_article,new Auteur ("ghailene","souissi"));
		int index = articles.indexOf(article);
		Chercheur chercheur = chercheurs.get(new ClefChercheur(nomAuteur, prenomAuteur));
		if (index < 0) {
			throw new ArticleInexistant("l'article d'id '" + id_article + "' n'existe pas");
		} else {
			if (chercheur == null) {
				throw new ChercheurInexistant(
						"l'auteur'" + nomAuteur + " " + prenomAuteur + "'n'existe pas");
			} 
			if (article.getSoumis()==true)  {
					throw new ArticleDejaSoumis(
							"l'article d'id : " + id_article + "est deja soumis");
			} 
				articles.get(index).ajouterAuteur(chercheur);
				
			}
			
		
	}
	
	
	
	
	

	/**
	 * retire un chercheur d'une institution.
	 * 
	 * @param nomChercheur
	 *            nom du chercheur.
	 * @param prenomChercheur
	 *            prénom du chercheur.
	 * @param nomInstitution
	 *            nom de l'institution.
	 */
	public void retireChercheurAInstitution(final String nomChercheur, final String prenomChercheur,
			final String nomInstitution) {
		throw new UnsupportedOperationException();
	}
	
	public void retireAuteur_a_Article(final String nomAuteur, final String prenomAuteur,
			final Long id_article) {
		throw new UnsupportedOperationException();
	}
	
	public void SoumettreArticle(Article article,Auteur Aut) throws AuteurInterdit,ArticleDejaSoumis {
		if (article==null) {
			throw new IllegalArgumentException("l'article n'est pas fourni");
		}
		if(Aut==null) {
			throw new IllegalArgumentException("l'auteur n'est pas fourni");
		}
		if(!article.getCorrespondant().equals(Aut)) {
			throw new AuteurInterdit("chercheur '" + Aut.getNom() + " " + Aut.getPrenom() + "n'a pas le droit de soumettre");
		}
		if(article.getSoumis()==true) {
			throw new ArticleDejaSoumis("article déja soumis");
		}
		
		
		article.setSoumis(true);
			
		LocalDate Date_soumission= Datutil.aujourdhui();
		article.setDate_soumission(Date_soumission);
		
	}
	
	
	
	

	
}
