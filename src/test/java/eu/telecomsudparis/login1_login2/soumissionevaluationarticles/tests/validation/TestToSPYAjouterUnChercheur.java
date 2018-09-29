// CHECKSTYLE:OFF
package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;

public class TestToSPYAjouterUnChercheur {

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
	public void ajouterUnChercheurTest1Jeu1() throws Exception {
		toSpy.ajouterChercheur(null, "Émeline");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurTest1Jeu2() throws Exception {
		toSpy.ajouterChercheur("", "Émeline");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurTest2Jeu1() throws Exception {
		toSpy.ajouterChercheur("Dupont", null);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurTest2Jeu2() throws Exception {
		toSpy.ajouterChercheur("Dupont", "");
	}

	@Test
	public void ajouterUnChercheurTest4Puis3Jeu1() throws Exception {
		toSpy.ajouterChercheur("Dupont", "Émeline");
		try {
			toSpy.ajouterChercheur("Dupont", "Émeline");
			Assert.fail("ajout chercheur seconde fois doit être refusé");
		} catch (ChercheurDejaPresent ex) {
			// nop
		}
	}

	@Test
	public void ajouterUnChercheurTest4Jeu1() throws Exception {
		toSpy.ajouterChercheur("Dupont", "Émeline");
		toSpy.ajouterChercheur("Durand", "Émeline");
	}

	@Test
	public void ajouterUnChercheurTest4Jeu2() throws Exception {
		toSpy.ajouterChercheur("Dupont", "Émeline");
		toSpy.ajouterChercheur("Dupont", "Émelyne");
	}
}
