// CHECKSTYLE:OFF
package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.unitaires;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Chercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ClefChercheur;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.Institution;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;

public class TestInstitution {

	private Chercheur chercheur;

	@Before
	public void setUp() throws ChercheurDejaPresent, ChercheurInexistant, ChaineDeCaracteresNullOuVide {
		chercheur = new Chercheur("Ghailene", "Souissi");
	}

	@After
	public void tearDown() {
		chercheur = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest1Jeu1() throws Exception {
		new Institution(null, "9 rue Charles Fourier, 91011 Évry cedex");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest1Jeu2() throws Exception {
		new Institution("", "9 rue Charles Fourier, 91011 Évry cedex");
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest2Jeu1() throws Exception {
		new Institution("Télécom SudParis", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructeurTest2Jeu2() throws Exception {
		new Institution("Télécom SudParis", "");
	}

	@Test
	public void constructeurTest3() throws Exception {
		Institution institution = new Institution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
		Assert.assertNotNull(institution.getNom());
		Assert.assertNotEquals("", institution.getNom());
		Assert.assertNotNull(institution.getAdresse());
		Assert.assertNotEquals("", institution.getAdresse());
		Assert.assertNotNull(institution.getChercheurs());
		Assert.assertTrue(institution.getChercheurs().isEmpty());
		// test de l'invariant vérifié par assertion à la fin du constructeur ;
		// invariant = méthode privée
	}

	@Test(expected = IllegalArgumentException.class)
	public void ajouterChercheurTest1() throws Exception {
		Institution institution = new Institution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
		institution.ajouterChercheur(null);
	}

	@Test
	public void ajouterChercheurTest3Puis2() throws Exception {
		Institution institution = new Institution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
		int nbChercheurs = institution.getChercheurs().size();
		institution.ajouterChercheur(chercheur);
		Assert.assertEquals(nbChercheurs + 1, institution.getChercheurs().size());
		Assert.assertTrue(
				institution.getChercheurs().containsKey(new ClefChercheur(chercheur.getNom(), chercheur.getPrenom())));
		try {
			institution.ajouterChercheur(chercheur);
			Assert.fail();
		} catch (ChercheurTravailleDejaPourInstitution e) {
			// nop
		}
	}
}
