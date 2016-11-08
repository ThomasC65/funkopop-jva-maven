package io.robusta.jpa.demo;

import java.util.List;

import javax.persistence.EntityManager;

import io.robusta.fora.EmFactory;
import io.robusta.jpa.demo.entities.FunkoPop;
import io.robusta.jpa.demo.entities.Universe;

public class JpaApplication {

	public static void main(String[] args) {

		// We start
		EntityManager em = EmFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println("  ========== STARTING WORK ======= ");

		
		Universe lotr = new Universe("LOTR");
		Universe starTrek = new Universe("StarTrek");
		Universe DBZ = new Universe("DBZ");
		Universe starWars = new Universe("Star Wars");		
		
		
			FunkoPop gandalf = new FunkoPop("Gandalf",lotr);        
	        FunkoPop aragorn= new FunkoPop("Aragorn", lotr);
	        aragorn.setWaterproof(true);
	        
	        FunkoPop sangoku= new FunkoPop("Sangoku", DBZ);
	        sangoku.setWaterproof(true);
	        
	        FunkoPop spok = new FunkoPop("Spok", starTrek);
	        FunkoPop kirk = new FunkoPop("Kirk", starTrek);
	        FunkoPop mcCoy = new FunkoPop("McCoy", starTrek);	        
	        
	        FunkoPop yoda = new FunkoPop("Yoda", starWars);
	        
	        em.persist(lotr);
	        em.persist(starTrek);
	        em.persist(DBZ);
	        em.persist(starWars);
	        
	        em.persist(sangoku);
	        em.persist(gandalf);
	        em.persist(aragorn);
	        em.persist(kirk);
	        em.persist(sangoku);
	        em.persist(spok);
	        em.persist(yoda);
	        em.persist(mcCoy);

	        
	        int idGandalf = gandalf.getId();
	        System.out.println("id of Gandalf : " + idGandalf);
	        
	        FunkoPop gandalfFetched = em.find(FunkoPop.class, idGandalf);
	        System.out.println("gandalf fetched : " +gandalfFetched.getName()); 
		
		System.out.println("  ========== COMMIT ======= ");
		em.getTransaction().commit();
		em.close();
		
		System.out.println("  ========== NEW QUERY ======= ");
		
		
		EmFactory.transaction( en -> { //en est une Entity Manager
			
			String query  =" SELECT f FROM FunkoPop f WHERE f.universe = :universe ";
					
			
			List<FunkoPop> list = 
					en.createQuery(query, FunkoPop.class)
					.setParameter("universe", starTrek)
					.getResultList();
			
			System.out.println(list);
			
		});
		
		
		EmFactory.getInstance().close();
		

	
		
		
	}
}
