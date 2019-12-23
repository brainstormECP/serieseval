/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serieseval.controller;

import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;
import serieseval.model.*;

/**
 *
 * @author Laura
 */
public class TestOptionController {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "seriesevalPU" );   
    
    public void Create(String name){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Testoption grupo = new Testoption(0, name);                   
        em.persist(grupo);        
        em.flush();
        em.getTransaction().commit();
        em.close();
    } 
    
    public void Editar(Testoption testOption) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Testoption u = em.getReference(Testoption.class, testOption.getIdtestoption());
        
        u.setName(testOption.getName());
              
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void Borrar(Testoption testOption) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Testoption u = em.getReference(Testoption.class, testOption.getIdtestoption());
        em.remove(u);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
