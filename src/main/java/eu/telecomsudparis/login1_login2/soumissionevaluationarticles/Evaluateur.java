package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;



public class Evaluateur extends Chercheur{
	
	public Evaluateur (final String nom , final String prenom) {
		super(nom,prenom);
	}
	
	public void Evaluer (Article article,Evalue evaluation) {
		article.setevaluation(evaluation);
		
	}
	
	
}
