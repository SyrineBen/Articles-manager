	package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaSoumis;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurInterdit;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;

public class Auteur extends Chercheur{
	
	private List<Article> articles;
	
	
	
	public Auteur (final String nom , final String prenom) {
		super(nom,prenom);
		this.articles = new ArrayList<>();
		
	}
	
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	//id unique
	public void CreerArticle(Long id ,Auteur Correspondant) {
		if (id == null || id.equals((long)0)) {
			throw new IllegalArgumentException("id null ou vide");
		}
		if (Correspondant == null) {
			throw new IllegalArgumentException("Correspondant null ou vide");
		}
		Article article = new Article(id ,Correspondant);
	}
	
	public void AjouterArticle(Article article)throws AuteurEcritDejaArticle {
		if (article == null) {
			throw new IllegalArgumentException("l'article n'est pas fournie");
		}
		// programmation défensive
		if (articles.contains(article)) {
			throw new AuteurEcritDejaArticle(
					"l'auteur deja ecrit cet article'" + article.getCorrespondant().getNom() + "'");
		}
		articles.add(article);
		assert invariant();
	}
	
	public void SoumettreArticle(Article article) throws AuteurInterdit,ArticleDejaSoumis {
		if (article==null) {
			throw new IllegalArgumentException("l'article n'est pas fourni");
		}
		
		if(new Auteur(this.getNom(),this.getPrenom())==article.getCorrespondant()) {
			throw new AuteurInterdit("chercheur '" + getNom() + " " + getPrenom() + "n'a pas le droit de soumettre");
		}
		if(article.getSoumis()==true) {
			throw new ArticleDejaSoumis("article déja soumis");
		}
		
		article.setSoumis(true);
		LocalDate Date_soumission= Datutil.aujourdhui();
		article.setDate_soumission(Date_soumission);
		
	}
	


}
