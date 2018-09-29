package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.unitaires;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Article;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Auteur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Chercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ClefChercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Institution;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
public class TestArticle {
	private Auteur auteur;
	
	@Before
	public void setUp() throws ChercheurDejaPresent, ChercheurInexistant, ChaineDeCaracteresNullOuVide {
		auteur = new Auteur("Dupont", "Émeline");
	}
	@After
	public void tearDown() {
		auteur = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest1Jeu1() throws Exception {
		new Article (null, new Auteur("ghailene","souissi"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest1Jeu2() throws Exception {
		new Article((long) 0, new Auteur("ghailene","souissi"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest2Jeu1() throws Exception {
		new Article ((long) 1, null);
	}
	public void constructeurTest3() throws Exception {
		Article article = new Article((long)2,new Auteur("ghailene","souissi"));
		Assert.assertNotNull(article.getId());
		Assert.assertNotEquals("", article.getId());
		Assert.assertNotNull(article.getCorrespondant());
		Assert.assertNotEquals("", article.getCorrespondant());
		Assert.assertNotNull(article.getCoAuteur());
		Assert.assertTrue(article.getCoAuteur().size()==1);//chaque article doit avoir au moins un auteur qui est le correspondant
		
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void ajouterAuteurTest1() throws Exception {
		Article article = new Article((long)3, new Auteur("Syrine","Ben"));
		article.ajouterAuteur(null);
	}

	@Test
	public void ajouterAuteurTest3Puis2() throws Exception {
		Article article = new Article((long)3, new Auteur("Syrine","Ben"));
		int nbAuteurs = article.getCoAuteur().size();
		article.ajouterAuteur(auteur);
		Assert.assertEquals(nbAuteurs + 1, article.getCoAuteur().size());
		Assert.assertTrue(
				article.getCoAuteur().contains(new Auteur(auteur.getNom(), auteur.getPrenom())));
		try {
			article.ajouterAuteur(auteur);;
			Assert.fail();
		} catch (AuteurEcritDejaArticle e) {
			// nop
		}
	}


}
