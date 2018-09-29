package eu.telecomsudparis.login1_login2.soumissionevaluationarticles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import eu.telecomsudparis.csc4102.util.Datutil;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.ArticleDejaSoumis;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurEcritDejaArticle;
import eu.telecomsudparis.login1_login2.soumissionevaluationarticles.exception.AuteurInterdit;

public class Article {
	private Long id ;
	private String titre; 
	private String contenu ;
	private String resume ;
	private Boolean soumis ;
	private Evalue evaluation; 
	private LocalDate date_soumission;
	private Auteur Correspondant ; 
	private List<Chercheur> coAuteur;
	
	public Article() {
		
	}
	
	public Article(final Long id , final Auteur Correspondant) {
		
		if (id == null || id==(long)0) {
			throw new IllegalArgumentException("id null ou vide");
		}
		
		
		if (Correspondant == null || Correspondant.equals("")) {
			throw new IllegalArgumentException("Correspondant null ou vide");
		}
		
		
		
		
		
		this.id = id;
		this.titre = null;
		this.contenu = null;
		this.resume = null;
		this.soumis = false;
		this.evaluation = null;
		this.Correspondant=Correspondant ;
		this.date_soumission = null;
		this.coAuteur = new ArrayList<>();
		assert invariant();
		/**
		 * vérifie l'invariant de l'objet.
		 * 
		 * @return vrai si l'invariant est vérifié.
		 */
	}
	
		
		public boolean invariant() {
			return id != null && !id.equals((long)0) &&
					soumis!=null && !soumis.equals("")&&
					Correspondant!=null && !Correspondant.equals("")&&
					coAuteur!=null ;
					
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getContenu() {
			return contenu;
		}

		public void setContenu(String contenu) {
			this.contenu = contenu;
		}

		public String getResume() {
			return resume;
		}

		public void setResume(String resume) {
			this.resume = resume;
		}

		public Boolean getSoumis() {
			return soumis;
		}

		public void setSoumis(Boolean soumis) {
			this.soumis = soumis;
		}

		public Evalue getevaluation() {
			return evaluation;
		}

		public void setevaluation(Evalue evaluation) {
			this.evaluation = evaluation;
		}

		public LocalDate getDate_soumission() {
			return date_soumission;
		}

		public void setDate_soumission(LocalDate date_soumission) {
			this.date_soumission = date_soumission;
		}

		public List<Chercheur> getCoAuteur() {
			return coAuteur;
		}

		public void setCoAuteur(List<Chercheur> coAuteur) {
			this.coAuteur = coAuteur;
		}
		public Evalue getEvaluation() {
			return evaluation;
		}

		public void setEvaluation(Evalue evaluation) {
			this.evaluation = evaluation;
		}
		
		
		
		public Auteur getCorrespondant() {
			return Correspondant;
		}

		public void setCorrespondant(Auteur correspondant) {
			Correspondant = correspondant;
		}

		public void ajouterAuteur(final Chercheur auteur) throws AuteurEcritDejaArticle {
			if (auteur == null) {
				throw new IllegalArgumentException("l'auteur n'est pas fournie");
			}
			// programmation défensive
			if (coAuteur.contains(auteur)) {
				throw new AuteurEcritDejaArticle(
						"l'auteur exist deja dans la liste des coAuteur '" + auteur.getNom() + "'");
			}
			
			coAuteur.add(auteur); 
			assert invariant();
		}
		/*
		 le correspondant peut soumettre un article sans fournir toute les informations mais l'article sera modifié et non soumis
		 si toute les informations sont soumis, l'article sera soumis.
		 */
		
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Article other = (Article) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

	

		
		
		
	}
	
	
