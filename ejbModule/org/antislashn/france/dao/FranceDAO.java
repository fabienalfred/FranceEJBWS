package org.antislashn.france.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.antislashn.france.entities.Ville;

@Stateless	// cycle de vie
public class FranceDAO {
	@PersistenceContext EntityManager em;	// injection de dépendance
	
	@PostConstruct
	public void init(){
		System.out.println(">>> PostConstruct FranceDAO");
	}
	
	@SuppressWarnings("unchecked")
	public List<Ville> getVillesByCodePostal(String cp){
		return em.createNamedQuery("Ville.getVillesByCodePostal").setParameter("cp", cp+"%").getResultList();
	}
}
