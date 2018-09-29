// CHECKSTYLE:OFF
package eu.telecomsudparis.login1_login2.soumissionevaluationarticles.tests.validation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.ToSPy;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ChaineDeCaracteresNullOuVide;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.InstitutionDejaPresente;

public class TestToSPYAjouterUneInstitution {

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
	public void ajouterUneInstitutionTest1Jeu1() throws Exception {
		toSpy.ajouterInstitution(null, "9 rue Charles Fourier, 91011 Évry cedex");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUneInstitutionTest1Jeu2() throws Exception {
		toSpy.ajouterInstitution("", "9 rue Charles Fourier, 91011 Évry cedex");
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUneInstitutionTest2Jeu1() throws Exception {
		toSpy.ajouterInstitution("Télécom SudParis", null);
	}

	@Test(expected = ChaineDeCaracteresNullOuVide.class)
	public void ajouterUneInstitutionTest2Jeu2() throws Exception {
		toSpy.ajouterInstitution("Télécom SudParis", "");
	}

	@Test
	public void ajouterAjouterUnMotClefTest4Puis3() throws Exception {
		toSpy.ajouterInstitution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
		try {
			toSpy.ajouterInstitution("Télécom SudParis", "9 rue Charles Fourier, 91011 Évry cedex");
			Assert.fail("ajout institution seconde fois doit être refusé");
		} catch (InstitutionDejaPresente ex) {
			// nop
		}
	}

}
