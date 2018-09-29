package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Auteur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaPresent;
public class TestToSPYAjouterUnArticle {
	private ToSPy toSpy;

	@Before
	public void setUp() {
		toSpy = new ToSPy();
	}

	@After
	public void tearDown() {
		toSpy = null;
	}
	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnArticleTest1() throws Exception {
		toSpy.ajouterArticle((long)5,null );
	}
	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnArticleTest1Jeu1() throws Exception {
		toSpy.ajouterArticle(null,new Auteur("ghailene","souissi") );
	}
	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnArticleTest2Jeu2() throws Exception {
		toSpy.ajouterArticle((long)0,new Auteur("ghailene","souissi") );
	}
	
	
	@Test
	public void ajouterUnArticleTest4() throws Exception {
		toSpy.ajouterArticle((long)1,new Auteur("ghailene","souissi"));
		try {
			toSpy.ajouterArticle((long)1,new Auteur("ghailene","souissi"));
			Assert.fail("ajout chercheur seconde fois doit être refusé");
		} catch (ArticleDejaPresent ex) {
			// nop
		}
	}

}
