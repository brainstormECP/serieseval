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
public class AlgorithmController {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "seriesevalPU" );   
    
    public void Create(String name, Dmgroup groupId){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Algorithm algoritmo = new Algorithm(0,name);  
        
        algoritmo.setIdgroup(groupId);        
        em.persist(algoritmo);        
        em.flush();
        em.getTransaction().commit();
        em.close();
    } 
    
    public void Editar(Algorithm algoritmo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Algorithm u = em.getReference(Algorithm.class, algoritmo.getIdalgorithm());        
        u.setName(algoritmo.getName());        
        u.setIdgroup(algoritmo.getIdgroup());        
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void Borrar(Algorithm algoritmo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Algorithm u = em.getReference(Algorithm.class, algoritmo.getIdalgorithm());  
        em.remove(u);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
