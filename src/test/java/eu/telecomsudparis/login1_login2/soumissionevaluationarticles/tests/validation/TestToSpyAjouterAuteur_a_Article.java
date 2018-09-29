package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Article;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Auteur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaSoumis;

public class TestToSpyAjouterAuteur_a_Article {
	private ToSPy toSpy;
	
	@Before
	public void setUp()throws ChercheurDejaPresent, ArticleDejaPresent ,ChaineDeCaracteresNullOuVide{
		toSpy = new ToSPy();
		toSpy.ajouterChercheur("Ghailene", "Souissi");
		toSpy.ajouterArticle((long)2, new Auteur("Syrine","Ben"));
		Article article =new Article((long)3, new Auteur("Syrine","Ben"));
		article.setSoumis(true);
		toSpy.ajouterArticle((long)3, new Auteur("Syrine","Ben"));
		System.out.print(article.getSoumis());
		
	}
	@After
	public void tearDown() {
		toSpy = null;
	}
	
	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest1Jeu1() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi",null );
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest1Jeu2() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi", (long)0);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest2Jeu1() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", null, (long)2);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest2Jeu2() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "", (long)2);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest3Jeu1() throws Exception {
		toSpy.ajouterAuteur_a_Article(null, "Souissi", (long)2);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnAuteur_a_ArticleTest3Jeu2() throws Exception {
		toSpy.ajouterAuteur_a_Article("", "Souissi", (long)2);
	}

	@Test(expected = ChercheurInexistant.class)
	public void ajouterUnAuteur_a_ArticleTest4() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene2", "Souissi", (long)2);
	}

	@Test(expected = ArticleInexistant.class)
	public void ajouterUnAuteur_a_ArticleTest5() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi", (long)20);
	}

	@Test
	public void ajouterUnAuteur_a_ArticleTest6Puis6() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi", (long)2);
		try {
			toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi", (long)2);
			Assert.fail("ajout auteur à article seconde fois doit être refusé");
		} catch (AuteurEcritDejaArticle ex) {
			// nop
		}
	}
	@Test(expected = ArticleDejaSoumis.class)
	public void ajouterUnAuteur_a_ArticleTest6() throws Exception {
		toSpy.ajouterAuteur_a_Article("Ghailene", "Souissi", (long)3);
	}

}
