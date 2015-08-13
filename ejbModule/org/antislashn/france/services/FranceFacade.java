package org.antislashn.france.services;

import javax.annotation.PostConstruct;
import javax.annotation.processing.SupportedOptions;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.antislashn.france.dao.FranceDAO;
import org.antislashn.france.entities.Ville;

/**
 * Session Bean implementation class FranceFracade
 */
@Stateless
@LocalBean
@Startup	// démarré avec l'appli
@WebService
public class FranceFacade {

	@EJB private FranceDAO dao;
	
    public FranceFacade() {
        System.out.println(">>> Constructeur FranceFacade()");
    }
    
    @PostConstruct
    @WebMethod(exclude=true)
    public void init(){
    	System.out.println(">>> PostConstruct FranceFacade");
    }
    
    public Ville[] getVillesByCodePostal(String cp){
    	return dao.getVillesByCodePostal(cp).toArray(new Ville[0]);
    }

}
