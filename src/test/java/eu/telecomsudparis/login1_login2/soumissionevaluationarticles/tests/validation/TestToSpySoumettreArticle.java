package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Article;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Auteur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Chercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurInterdit;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaSoumis;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestToSpySoumettreArticle {
	private ToSPy toSpy;
	private Auteur auteur = new Auteur("Ghailene","Ben");
	private Article article = new Article((long)2,new Auteur("Syrine","Ben"));
	private Article article1 = new Article((long)3,new Auteur("Syrine","Ben"));
	
	@Before
	public void setUp() throws AuteurEcritDejaArticle,ChaineDeCaracteresNullOuVide,ChercheurDejaPresent,ArticleDejaPresent {
		toSpy = new ToSPy();
		article.ajouterAuteur(auteur);
		article1.setSoumis(true);
		//System.out.println(article.getSoumis());
	}

	@After
	public void tearDown() {
		toSpy = null;
	}
	@Test(expected = IllegalArgumentException.class)
	public void SoumettreUnArticleTest1() throws Exception {
		toSpy.SoumettreArticle(null, auteur);
	}
	@Test(expected = IllegalArgumentException.class)
	public void SoumettreUnArticleTest2() throws Exception {
		toSpy.SoumettreArticle(article,null);
	}
	
	@Test(expected = AuteurInterdit.class)
	public void SoumettreUnArticleTest3() throws Exception {
		
		toSpy.SoumettreArticle(article, new Auteur("Ghailene","Ben"));
		
	}
	
	@Test(expected = ArticleDejaSoumis.class)
	public void SoumettreUnArticleTest4puis4() throws Exception {
		toSpy.SoumettreArticle(article, new Auteur("Syrine","Ben"));
		try {
			System.out.print("scr"+article.getSoumis());
			toSpy.SoumettreArticle(article, new Auteur("Syrine","Ben"));
			Assert.fail("article Deja soumis");
		} catch (ArticleDejaSoumis ex) {
			// nop
		}
	}
	
	

}
