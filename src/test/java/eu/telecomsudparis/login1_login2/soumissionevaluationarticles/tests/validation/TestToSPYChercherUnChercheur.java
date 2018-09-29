// CHECKSTYLE:OFF
package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Chercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;

public class TestToSPYChercherUnChercheur {

	private ToSPy toSpy;

	@Before
	public void setUp() throws ChercheurDejaPresent, ChaineDeCaracteresNullOuVide {
		toSpy = new ToSPy();
		toSpy.ajouterChercheur("Dupont", "Émeline");
	}

	@After
	public void tearDown() {
		toSpy = null;
	}

	@Test(expected=ChaineDeCaracteresNullOuVide.class)
	public void creerChercherUnChercheurTest1() throws Exception {
		toSpy.chercherChercheur(null, "Émeline");
	}

	@Test(expected=ChaineDeCaracteresNullOuVide.class)
	public void creerChercherUnChercheurTest2() throws Exception {
		toSpy.chercherChercheur("", "Émeline");
	}

	@Test(expected=ChaineDeCaracteresNullOuVide.class)
	public void creerChercherUnChercheurTest3() throws Exception {
		toSpy.chercherChercheur("Dupont", null);
	}

	@Test(expected=ChaineDeCaracteresNullOuVide.class)
	public void creerChercherUnChercheurTest4() throws Exception {
		toSpy.chercherChercheur("Dupont", "");
	}

	@Test(expected=ChercheurInexistant.class)
	public void creerChercherUnChercheurTest5() throws Exception {
		toSpy.chercherChercheur("Dupont", "Émelyne");
	}

	@Test
	public void creerChercherUnChercheurTest6() throws Exception {
		Chercheur chercheur = toSpy.chercherChercheur("Dupont", "Émeline");
		Assert.assertEquals("Dupont", chercheur.getNom());
		Assert.assertEquals("Émeline", chercheur.getPrenom());
	}
}
