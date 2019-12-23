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
public class GroupController{
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "seriesevalPU" );   
    
    public void Create(String name){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dmgroup grupo = new Dmgroup(0, name);                   
        em.persist(grupo);        
        em.flush();
        em.getTransaction().commit();
        em.close();
    } 
    
    public void Editar(Dmgroup grupo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dmgroup u = em.getReference(Dmgroup.class, grupo.getIdgroup());
        
        u.setName(grupo.getName());
              
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void Borrar(Dmgroup grupo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Dmgroup u = em.getReference(Dmgroup.class, grupo.getIdgroup());
        em.remove(u);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
