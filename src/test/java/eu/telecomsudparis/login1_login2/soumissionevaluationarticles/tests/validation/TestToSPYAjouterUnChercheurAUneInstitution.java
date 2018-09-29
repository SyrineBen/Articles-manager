// CHECKSTYLE:OFF
package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurDejaPresent;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurInexistant;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChercheurTravailleDejaPourInstitution;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.InstitutionDejaPresente;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.InstitutionInexistante;

public class TestToSPYAjouterUnChercheurAUneInstitution {

	private ToSPy toSpy;

	@Before
	public void setUp() throws InstitutionDejaPresente, ChercheurDejaPresent, ChaineDeCaracteresNullOuVide {
		toSpy = new ToSPy();
		toSpy.ajouterChercheur("Dupont", "Émeline");
		toSpy.ajouterInstitution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
	}

	@After
	public void tearDown() {
		toSpy = null;
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest1Jeu1() throws Exception {
		toSpy.ajouterChercheurAInstitution(null, "Émeline", "Télécom SudParis");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest1Jeu2() throws Exception {
		toSpy.ajouterChercheurAInstitution("", "Émeline", "Télécom SudParis");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest2Jeu1() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", null, "Télécom SudParis");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest2Jeu2() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", "", "Télécom SudParis");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest3Jeu1() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", "Émeline", null);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUnChercheurAUneInstitutionTest3Jeu2() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", "Émeline", "");
	}

	@Test(expected = ChercheurInexistant.class)
	public void ajouterUnChercheurAUneInstitutionTest4() throws Exception {
		toSpy.ajouterChercheurAInstitution("Durand", "Émeline", "Télécom SudParis");
	}

	@Test(expected = InstitutionInexistante.class)
	public void ajouterUnChercheurAUneInstitutionTest5() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", "Émeline", "Télécom ParisTech");
	}

	@Test
	public void ajouterUnChercheurAUneInstitutionTest6Puis6() throws Exception {
		toSpy.ajouterChercheurAInstitution("Dupont", "Émeline", "Télécom SudParis");
		try {
			toSpy.ajouterChercheurAInstitution("Dupont", "Émeline", "Télécom SudParis");
			Assert.fail("ajout chercheur à institution seconde fois doit être refusé");
		} catch (ChercheurTravailleDejaPourInstitution ex) {
			// nop
		}
	}
}
